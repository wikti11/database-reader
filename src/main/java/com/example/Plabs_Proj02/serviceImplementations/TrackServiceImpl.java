package com.example.Plabs_Proj02.serviceImplementations;

import com.example.Plabs_Proj02.repositories.TrackRepository;
import com.example.Plabs_Proj02.services.TrackService;
import com.example.Plabs_Proj02.entities.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Optional<Track> getTrackById(Integer id){
        return trackRepository.findById(id);
    }

    @Override
    public Track saveTrack(Track track){
        return trackRepository.save(track);
    }

    @Override
    public void deleteTrack(Integer id){
        trackRepository.deleteById(id);
    }

    public Iterable<Track> findAllTracksWithPagination(Integer pageNr, Integer amountOnPage){
        return trackRepository.findAll(PageRequest.of(pageNr, amountOnPage));
    }

    public Collection<Track> findAllTrackNames(){
        return trackRepository.findAllTrackNames();
    }

    public Collection<Track> findAllTracksAbove4000(){
        return trackRepository.findTracksAbove4000();
    }

    public Track findTracksByYearBuilt(Integer yearBuilt){
        return trackRepository.findTracksByYearBuilt(yearBuilt);
    }

    public Track findTracksByCountryAndCorners(String country, Integer corners){
        return trackRepository.findTrackByCountryAndCorners(country, corners);
    }
}
