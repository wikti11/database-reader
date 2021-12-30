package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.entities.Team;
import com.example.Plabs_Proj02.repositories.DriverRepository;
import com.example.Plabs_Proj02.entities.Driver;

import com.example.Plabs_Proj02.services.DriverService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(value = "/driver")
public class DriverController {
    @Autowired
    DriverRepository driverRepository;

    @Autowired
    DriverService driverService;

    @PostMapping(value = "/add")
    public @ResponseBody String addNewDriver(@RequestParam String driverFirstName, String driverLastName, Team driverTeam, Integer driverNumber, Integer driverAge, String driverNationality){
        Driver d = new Driver();
        d.setDriverFirstName(driverFirstName);
        d.setDriverLastName(driverLastName);
        d.setDriverTeam(driverTeam);
        d.setDriverNumber(driverNumber);
        d.setDriverAge(driverAge);
        d.setDriverNationality(driverNationality);
        d.setDriverDate(DateTime.now());
        driverRepository.save(d);
        return "Driver has been successfully saved.";
    }

    @GetMapping(value = "/all")
    public @ResponseBody Iterable<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView deleteDriver(HttpServletResponse response, @PathVariable Integer id){
        driverService.deleteDriver(id);
        return new RedirectView("/driver/all",true);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> editDriver(@RequestBody Driver driver){
        Optional<Driver> driverFromData = driverService.getDriverById(driver.getDriverId());
        if(Objects.nonNull(driverFromData)){
            driverService.saveDriver(driver);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/paginated/{pageNr}")
    public Iterable<Driver> findAllDriversWithPagination(@PathVariable Integer pageNr, Integer amountOnPage){
        return driverService.findAllDriversWithPagination(pageNr, 5);
    }
    @GetMapping(value = "/lastname")
    public Collection<Driver> findAllDriversLastNames(){
        return driverService.findAllDriversLastNames();
    }

    @GetMapping(value = "/age/above30")
    public Collection<Driver> findDriversAbove30(){
        return driverService.findDriversAbove30();
    }

    @GetMapping(value = "/number/{number}")
    public Driver findDriversByNumber (@PathVariable Integer number){
        return driverService.findDriversByNumber(number);
    }

    @GetMapping(value = "/name/nationality/{name}/{nationality}")
    public Driver findDriversByFirstNameAndNationality (@PathVariable String name, @PathVariable String nationality){
        return driverService.findDriversByFirstNameAndNationality(name, nationality);
    }
}
