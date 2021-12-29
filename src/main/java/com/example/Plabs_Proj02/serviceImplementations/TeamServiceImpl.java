package com.example.Plabs_Proj02.serviceImplementations;

import com.example.Plabs_Proj02.repositories.TeamRepository;
import com.example.Plabs_Proj02.services.TeamService;
import com.example.Plabs_Proj02.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Optional<Team> getTeamById(Integer id){
        return teamRepository.findById(id);
    }

    @Override
    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id){
        teamRepository.deleteById(id);
    }

    public Iterable<Team> findAllTeamsWithPagination(Integer pageNr, Integer amountOnPage){
        return teamRepository.findAll(PageRequest.of(pageNr, amountOnPage));
    }

    public Collection<Team> findAllTeamNames(){
        return teamRepository.findAllTeamNames();
    }

    public Collection<Team> findAllTeamsFoundAfter1990(){
        return teamRepository.findTeamsFoundAfter1990();
    }

    public Team findTeamByEngineSupplier(String engineSupplier){
        return teamRepository.findTeamsByEngineSupplier(engineSupplier);
    }

    public Team findTeamByLocalizationAndEngineSupplier(String localization, String engineSupplier){
        return teamRepository.findTeamsByLocalizationAndEngineSupplier(localization, engineSupplier);
    }
}
