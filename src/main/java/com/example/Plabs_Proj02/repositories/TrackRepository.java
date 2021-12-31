package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface TrackRepository extends CrudRepository<Track, Integer>, PagingAndSortingRepository<Track, Integer> {
    @Query("SELECT t.trackName FROM Track t")
    Collection<Track> findAllTrackNames();

    @Query("SELECT t FROM Track t WHERE t.trackLength > 4000")
    Collection<Track> findTracksAbove4000();

    @Query("SELECT t FROM Track t WHERE t.trackYearBuilt = ?1")
    Track findTracksByYearBuilt(Integer year_built);

    @Query("SELECT t FROM Track t WHERE t.trackCountry = ?1 and t.trackCorners = ?2")
    Track findTrackByCountryAndCorners(String country, Integer corners);
}
