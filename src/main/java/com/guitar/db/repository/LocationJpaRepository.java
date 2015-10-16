package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Scott on 10/15/15.
 */
@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    // Note: built-in capability findBy{existing element}Like
    List<Location> findByStateLike(String stateName);
    List<Location> findByStateNotLike(String stateName);
    List<Location> findByStateNotLikeOrderByStateAsc(String stateName);
    List<Location> findByStateOrCountry(String value, String value2);
    List<Location> findByStateIsOrCountryEquals(String value, String value2);
    List<Location> findByStateAndCountry(String state, String country);
    List<Location> findByStateNot(String state);

    // StartingWith, EndingWith, and Containing automatically appends % character
    List<Location> findByStateStartingWith(String stateName);
    List<Location> findByStateIgnoreCaseStartingWith(String stateName);
    Location findFirstByStateIgnoreCaseStartingWith(String stateName);


}
