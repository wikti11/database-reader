package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.repositories.TeamRepository;
import com.example.Plabs_Proj02.entities.Team;

import com.example.Plabs_Proj02.services.TeamService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(value = "team")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @PostMapping(value = "/add")
    public @ResponseBody String addNewTeam (@RequestParam String teamName, @RequestParam String teamEngineSupplier
            , @RequestParam String teamLocalization, @RequestParam Integer teamYearFound){
        Team t = new Team();
        t.setTeamName(teamName);
        t.setTeamEngineSupplier(teamEngineSupplier);
        t.setTeamLocalization(teamLocalization);
        t.setTeamYearFound(teamYearFound);
        t.setTeamDate(DateTime.now());
        teamRepository.save(t);
        return "Team has been successfully saved.";
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView deleteTeam(HttpServletResponse response, @PathVariable Integer id){
        teamService.deleteTeam(id);
        return new RedirectView("/team/all",true);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> editTeam(@RequestBody Team team){
        Optional<Team> teamFromData = teamService.getTeamById(team.getTeamId());
        if(Objects.nonNull(teamFromData)){
            teamService.saveTeam(team);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/paginated/{pageNr}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Team> findAllTeamsWithPagination(@PathVariable Integer pageNr, Integer amountOnPage){
        return teamService.findAllTeamsWithPagination(pageNr, 5);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Team> findAllTeamNames() {
        return teamService.findAllTeamNames();
    }

    @GetMapping(value = "/yearfound/after1990", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Team> findAllTeamsFoundAfter1990(){
        return teamService.findAllTeamsFoundAfter1990();
    }

    @GetMapping(value = "/enginesupplier/{engineSupplier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team findTeamsByEngineSupplier(@PathVariable String engineSupplier){
        return teamService.findTeamByEngineSupplier(engineSupplier);
    }

    @GetMapping(value = "/localization/enginesupplier/{localization}/{engineSupplier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team findTeamsByLocalizationAndEngineSupplier(@PathVariable String localization, @PathVariable String engineSupplier){
        return teamService.findTeamByLocalizationAndEngineSupplier(localization, engineSupplier);
    }
}
