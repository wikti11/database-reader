package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.entities.Driver;
import com.example.Plabs_Proj02.entities.Track;
import com.example.Plabs_Proj02.repositories.ResultRepository;
import com.example.Plabs_Proj02.entities.Result;
import com.example.Plabs_Proj02.services.ResultService;

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
@RequestMapping(value = "/result")
public class ResultController {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ResultService resultService;

    @PostMapping(value = "/add")
    public @ResponseBody String addNewResult (@RequestParam String resultDate, Track resultTrack, Driver resultDriver, Integer resultPosition) {
        Result r = new Result();
        r.setResultDate(resultDate);
        r.setResultTrack(resultTrack);
        r.setResultDriver(resultDriver);
        r.setResultPosition(resultPosition);
        r.setResultDateTime(DateTime.now());
        resultRepository.save(r);
        return "Result has been successfully saved.";
    }

    @GetMapping(value = "/all")
    public @ResponseBody Iterable<Result> getAllResults(){
        return resultRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView deleteResult(HttpServletResponse response, @PathVariable Integer id){
        resultService.deleteResult(id);
        return new RedirectView("/result/all",true);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> editResult(@RequestBody Result result){
        Optional<Result> resultFromData = resultService.getResultById(result.getResultId());
        if(Objects.nonNull(resultFromData)){
            resultService.saveResult(result);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/paginated/{pageNr}")
    public Iterable<Result> findAllResultsWithPagination(@PathVariable Integer pageNr, Integer amountOnPage){
        return resultService.findAllResultsWithPagination(pageNr, 5);
    }

    @GetMapping(value = "/date")
    public Collection<Result> findAllResultDates(){
        return resultService.findAllResultDates();
    }

    @GetMapping(value = "/position/above10")
    public Collection<Result> findAllResultsPositionAbove10(){
        return resultService.findResultsPositionAbove10();
    }

    @GetMapping(value = "/position/{position}")
    public Result findAllResultsByPosition(@PathVariable Integer position){
        return resultService.findResultsByPosition(position);
    }

    @GetMapping(value = "/date/position/{date}/{position}")
    public Result findAllResultsByDateAndPosition(@PathVariable String date, @PathVariable Integer position){
        return resultService.findResultsByDateAndPosition(date,position);
    }
}
