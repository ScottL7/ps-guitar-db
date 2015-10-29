package com.guitar.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Scott on 10/15/15.
 */
@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

    //    select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood
    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqualAndWoodTypeContaining(BigDecimal low, BigDecimal high, String wood);

    List<Model> findByModelType_NameIn(List<String> types);

//    //select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood
//    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
//    List<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
//                                             @Param("highest") BigDecimal high,
//                                             @Param("wood") String wood);

    //select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood
    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
    Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
                                             @Param("highest") BigDecimal high,
                                             @Param("wood") String wood,
                                             Pageable page);
    List<Model> findAllModelsByType(@Param("name") String type);
}
