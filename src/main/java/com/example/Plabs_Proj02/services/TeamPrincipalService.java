package com.example.Plabs_Proj02.services;

import com.example.Plabs_Proj02.entities.TeamPrincipal;

import java.util.Collection;
import java.util.Optional;

public interface TeamPrincipalService {
    TeamPrincipal saveTeamPrincipal(TeamPrincipal teamPrincipal);

    void deleteTeamPrincipal(Integer id);

    Optional<TeamPrincipal> getTeamPrincipalById(Integer id);

    Iterable<TeamPrincipal> findAllTeamPrincipalsWithPagination(Integer pageNr, Integer amountOnPage);

    Collection<TeamPrincipal> findAllTeamPrincipalLastNames();

    Collection<TeamPrincipal> findAllTeamPrincipalsAbove45();

    TeamPrincipal findTeamPrincipalsByFirstName(String firstName);

    TeamPrincipal findTeamPrincipalsByAgeAndNationality(Integer age, String nationality);
}
