package com.example.Plabs_Proj02.serviceImplementations;

import com.example.Plabs_Proj02.entities.Team;
import com.example.Plabs_Proj02.repositories.TeamPrincipalRepository;
import com.example.Plabs_Proj02.services.TeamPrincipalService;
import com.example.Plabs_Proj02.entities.TeamPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TeamPrincipalServiceImpl implements TeamPrincipalService{
    @Autowired
    private TeamPrincipalRepository teamPrincipalRepository;

    @Override
    public Optional<TeamPrincipal> getTeamPrincipalById(Integer id){
        return teamPrincipalRepository.findById(id);
    }

    @Override
    public TeamPrincipal saveTeamPrincipal(TeamPrincipal teamPrincipal){
        return teamPrincipalRepository.save(teamPrincipal);
    }

    @Override
    public void deleteTeamPrincipal(Integer id){
        teamPrincipalRepository.deleteById(id);
    }

    public Iterable<TeamPrincipal> findAllTeamPrincipalsWithPagination(Integer pageNr, Integer amountOnPage){
        return teamPrincipalRepository.findAll(PageRequest.of(pageNr, amountOnPage));
    }

    public Collection<TeamPrincipal> findAllTeamPrincipalLastNames(){
        return teamPrincipalRepository.findAllTeamPrincipalLastNames();
    }

    public Collection<TeamPrincipal> findAllTeamPrincipalsAbove45(){
        return teamPrincipalRepository.findTeamPrincipalsAbove45();
    }

    public TeamPrincipal findTeamPrincipalsByFirstName(String firstName){
        return teamPrincipalRepository.findTeamPrincipalsByFirstName(firstName);
    }

    public TeamPrincipal findTeamPrincipalsByAgeAndNationality(Integer age, String nationality){
        return teamPrincipalRepository.findTeamPrincipalsByAgeAndNationality(age, nationality);
    }
}
