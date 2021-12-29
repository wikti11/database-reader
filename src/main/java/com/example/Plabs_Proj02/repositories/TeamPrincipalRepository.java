package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.TeamPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface TeamPrincipalRepository extends CrudRepository<TeamPrincipal, Integer>, PagingAndSortingRepository<TeamPrincipal, Integer> {
    @Query("SELECT t.last_name FROM Team_principal t")
    Collection<TeamPrincipal> findAllTeamPrincipalLastNames();

    @Query("SELECT t FROM Team_principal t WHERE t.age > 45")
    Collection<TeamPrincipal> findTeamPrincipalsAbove45();

    @Query("SELECT t FROM Team_principal t WHERE t.first_name = ?1")
    TeamPrincipal findTeamPrincipalsByFirstName(String first_name);

    @Query("SELECT t FROM Team_principal WHERE t.age = ?1 and t.nationality = ?2")
    TeamPrincipal findTeamPrincipalsByAgeAndNationality(Integer age, String nationality);
}
