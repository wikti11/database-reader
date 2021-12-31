package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.TeamPrincipal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface TeamPrincipalRepository extends CrudRepository<TeamPrincipal, Integer>, PagingAndSortingRepository<TeamPrincipal, Integer> {
    @Query("SELECT t.teamPrincipalLastName FROM TeamPrincipal t")
    Collection<TeamPrincipal> findAllTeamPrincipalLastNames();

    @Query("SELECT t FROM TeamPrincipal t WHERE t.teamPrincipalAge > 45")
    Collection<TeamPrincipal> findTeamPrincipalsAbove45();

    @Query("SELECT t FROM TeamPrincipal t WHERE t.teamPrincipalFirstName = ?1")
    TeamPrincipal findTeamPrincipalsByFirstName(String first_name);

    @Query("SELECT t FROM TeamPrincipal t WHERE t.teamPrincipalAge = ?1 and t.teamPrincipalNationality = ?2")
    TeamPrincipal findTeamPrincipalsByAgeAndNationality(Integer age, String nationality);
}
