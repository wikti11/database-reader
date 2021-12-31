package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface TeamRepository extends CrudRepository<Team, Integer>, PagingAndSortingRepository<Team, Integer> {
    @Query("SELECT t.teamName FROM Team t")
    Collection<Team> findAllTeamNames();

    @Query("SELECT t FROM Team t WHERE t.teamYearFound > 1990")
    Collection<Team> findTeamsFoundAfter1990();

    @Query("SELECT t FROM Team t WHERE t.teamEngineSupplier = ?1")
    Team findTeamsByEngineSupplier(String engine_supplier);

    @Query("SELECT t FROM Team t WHERE t.teamLocalization = ?1 and t.teamEngineSupplier = ?2")
    Team findTeamsByLocalizationAndEngineSupplier(String localization, String engine_supplier);

}
