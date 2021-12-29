package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.repositories.TrackRepository;
import com.example.Plabs_Proj02.entities.Track;

import com.example.Plabs_Proj02.services.TrackService;
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
@RequestMapping(value = "/track")
public class TrackController {
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackService trackService;

    @PostMapping(value = "/add")
    public @ResponseBody String addNewTrack (@RequestParam String trackName, Integer trackLength, Integer trackCorners, Integer trackYearBuilt, String trackCountry){
        Track t = new Track();
        t.setTrackName(trackName);
        t.setTrackLength(trackLength);
        t.setTrackCorners(trackCorners);
        t.setTrackYearBuilt(trackYearBuilt);
        t.setTrackCountry(trackCountry);
        t.setTrackDateTime(DateTime.now());
        trackRepository.save(t);
        return "Track has been saved successfully.";
    }

    @GetMapping(value = "/all")
    public @ResponseBody Iterable<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView deleteTrack(HttpServletResponse response, @PathVariable Integer id){
        trackService.deleteTrack(id);
        return new RedirectView("/track/all",true);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> editTrack(@RequestBody Track track){
        Optional<Track> trackFromData = trackService.getTrackById(track.getTrackId());
        if(Objects.nonNull(trackFromData)){
            trackService.saveTrack(track);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/paginated/{pageNr}")
    public Iterable<Track> findAllTracksWithPagination(@PathVariable Integer pageNr, Integer amountOnPage){
        return trackService.findAllTracksWithPagination(pageNr, 5);
    }

    @GetMapping(value = "/name")
    public Collection<Track> findAllTrackNames(){
        return trackService.findAllTrackNames();
    }

    @GetMapping(value = "/length/above4000")
    public Collection<Track> findAllTracksAbove4000(){
        return trackService.findAllTracksAbove4000();
    }

    @GetMapping(value = "/yearbuilt/{yearBuilt}")
    public Track findTracksByYearBuilt(@PathVariable Integer yearBuilt){
        return trackService.findTracksByYearBuilt(yearBuilt);
    }

    @GetMapping(value = "/country/corners/{country}/{corners}")
    public Track findTracksByCountryAndCorners(@PathVariable String country, @PathVariable Integer corners){
        return trackService.findTracksByCountryAndCorners(country, corners);
    }
}
