package com.example.Plabs_Proj02.serviceImplementations;

import com.example.Plabs_Proj02.repositories.DriverRepository;
import com.example.Plabs_Proj02.services.DriverService;
import com.example.Plabs_Proj02.entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Optional<Driver> getDriverById(Integer id){
        return driverRepository.findById(id);
    }

    @Override
    public Driver saveDriver(Driver driver){
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Integer id){
        driverRepository.deleteById(id);
    }

    public Iterable<Driver> findAllDriversWithPagination(Integer pageNr, Integer amountOnPage){
        return driverRepository.findAll(PageRequest.of(pageNr,amountOnPage));
    }

    public Collection<Driver> findAllDriversLastNames() {
        return driverRepository.findAllDriverLastNames();
    }

    public Collection<Driver> findDriversAbove30(){
        return driverRepository.findDriversAbove30();
    }

    public Driver findDriversByNumber(Integer number){
        return driverRepository.findDriversByNumber(number);
    }

    public Driver findDriversByFirstNameAndNationality(String firstName, String nationality){
        return driverRepository.findDriverByFirstNameAndNationality(firstName,nationality);
    }
}
