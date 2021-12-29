package com.example.Plabs_Proj02.services;

import com.example.Plabs_Proj02.entities.Track;

import java.util.Collection;
import java.util.Optional;

public interface TrackService {

    Track saveTrack(Track track);

    void deleteTrack(Integer id);

    Optional<Track> getTrackById(Integer id);

    Iterable<Track> findAllTracksWithPagination(Integer pageNr, Integer amountOnPage);

    Collection<Track> findAllTrackNames();

    Collection<Track> findAllTracksAbove4000();

    Track findTracksByYearBuilt(Integer yearBuilt);

    Track findTracksByCountryAndCorners(String country, Integer corners);

}
