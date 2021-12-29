package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface DriverRepository extends CrudRepository<Driver, Integer>, PagingAndSortingRepository<Driver, Integer> {
    @Query("SELECT d.last_name FROM Driver d")
    Collection<Driver> findAllDriverLastNames();

    @Query("SELECT d FROM Driver d WHERE d.length > 30")
    Collection<Driver> findDriversAbove30();

    @Query("SELECT d FROM Driver d WHERE d.number = ?1")
    Driver findDriversByNumber(Integer number);

    @Query("SELECT d FROM Driver d WHERE d.first_name = ?1 and d.nationality = ?2")
    Driver findDriverByFirstNameAndNationality(String first_name, String nationality);
}
