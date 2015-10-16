package com.guitar.db.repository;

import com.guitar.db.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Scott on 10/15/15.
 */
@Repository
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    // select m from Manufacturer m where m.foundedDate < :date
    List<Manufacturer> findByFoundedDateBefore(Date date);

    List<Manufacturer> findByActiveTrue();
    List<Manufacturer> findByActiveFalse();

    List<Manufacturer> getAllThatSellAcoustics(String name);
}
