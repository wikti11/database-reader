package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface TrackRepository extends CrudRepository<Track, Integer>, PagingAndSortingRepository<Track, Integer> {
    @Query("SELECT t.name FROM Track t")
    Collection<Track> findAllTrackNames();

    @Query("SELECT t FROM Track t WHERE t.length > 4000")
    Collection<Track> findTracksAbove4000();

    @Query("SELECT t FROM Track t WHERE t.year_built = ?1")
    Track findTracksByYearBuilt(Integer year_built);

    @Query("SELECT t FROM Track t WHERE t.country = ?1 and t.corners = ?2")
    Track findTrackByCountryAndCorners(String country, Integer corners);
}
