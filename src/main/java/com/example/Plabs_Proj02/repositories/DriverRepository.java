package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface DriverRepository extends CrudRepository<Driver, Integer>, PagingAndSortingRepository<Driver, Integer> {
    @Query("SELECT d.driverLastName FROM Driver d")
    Collection<Driver> findAllDriverLastNames();

    @Query("SELECT d FROM Driver d WHERE d.driverAge > 30")
    Collection<Driver> findDriversAbove30();

    @Query("SELECT d FROM Driver d WHERE d.driverNumber = ?1")
    Driver findDriversByNumber(Integer number);

    @Query("SELECT d FROM Driver d WHERE d.driverFirstName = ?1 and d.driverNationality = ?2")
    Driver findDriverByFirstNameAndNationality(String first_name, String nationality);
}
