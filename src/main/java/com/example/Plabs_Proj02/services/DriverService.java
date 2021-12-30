package com.example.Plabs_Proj02.services;

import com.example.Plabs_Proj02.entities.Driver;

import java.util.Collection;
import java.util.Optional;

public interface DriverService {
    Driver saveDriver(Driver driver);

    void deleteDriver(Integer id);

    Optional<Driver> getDriverById(Integer id);

    Iterable<Driver> findAllDriversWithPagination(Integer pageNr, Integer amountOnPage);

    Collection<Driver> findAllDriversLastNames();

    Collection<Driver> findDriversAbove30();

    Driver findDriversByNumber(Integer number);

    Driver findDriversByFirstNameAndNationality(String firstName, String nationality);
}
