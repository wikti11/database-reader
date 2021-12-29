package com.example.Plabs_Proj02.services;

import com.example.Plabs_Proj02.entities.Team;

import java.util.Collection;
import java.util.Optional;

public interface TeamService {

    Team saveTeam(Team team);

    void deleteTeam(Integer id);

    Optional<Team> getTeamById(Integer id);

    Iterable<Team> findAllTeamsWithPagination(Integer pageNr, Integer amountOnPage);

    Collection<Team> findAllTeamNames();

    Collection<Team> findAllTeamsFoundAfter1990();

    Team findTeamByEngineSupplier(String engineSupplier);

    Team findTeamByLocalizationAndEngineSupplier(String localization, String engineSupplier);

}
