package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.entities.Team;
import com.example.Plabs_Proj02.repositories.TeamPrincipalRepository;
import com.example.Plabs_Proj02.entities.TeamPrincipal;

import com.example.Plabs_Proj02.services.TeamPrincipalService;
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
@RequestMapping(value = "/teamprincipal")
public class TeamPrincipalController {
    @Autowired
    private TeamPrincipalRepository teamPrincipalRepository;

    @Autowired
    private TeamPrincipalService teamPrincipalService;

    @PostMapping(value = "/add")
    public @ResponseBody String addNewTeamPrincipal (@RequestParam String teamPrincipalFirstName
            , @RequestParam String teamPrincipalLastName, @RequestParam Team teamPrincipalTeam
            , @RequestParam Integer teamPrincipalAge, @RequestParam String teamPrincipalNationality){
        TeamPrincipal t = new TeamPrincipal();
        t.setTeamPrincipalFirstName(teamPrincipalFirstName);
        t.setTeamPrincipalLastName(teamPrincipalLastName);
        t.setTeamPrincipalTeam(teamPrincipalTeam);
        t.setTeamPrincipalAge(teamPrincipalAge);
        t.setTeamPrincipalNationality(teamPrincipalNationality);
        t.setTeamPrincipalDate(DateTime.now());
        teamPrincipalRepository.save(t);
        return "Team principal has been successfully saved.";
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<TeamPrincipal> getAllTeamPrincipals(){
        return teamPrincipalRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView deleteTeamPrincipal(HttpServletResponse response, @PathVariable Integer id){
        teamPrincipalService.deleteTeamPrincipal(id);
        return new RedirectView("/teamprincipal/all",true);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> editTeamPrincipal(@RequestBody TeamPrincipal teamPrincipal){
        Optional<TeamPrincipal> teamPrincipalFromData = teamPrincipalService.getTeamPrincipalById(teamPrincipal.getTeamPrincipalId());
        if(Objects.nonNull(teamPrincipalFromData)){
            teamPrincipalService.saveTeamPrincipal(teamPrincipal);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

   @GetMapping(value = "/paginated/{pageNr}", produces = MediaType.APPLICATION_JSON_VALUE)
   public Iterable<TeamPrincipal> findAllTeamPrincipalsWithPagination(@PathVariable Integer pageNr, Integer amountOnPage){
        return teamPrincipalService.findAllTeamPrincipalsWithPagination(pageNr, 5);
   }

   @GetMapping(value = "/lastname", produces = MediaType.APPLICATION_JSON_VALUE)
   public Collection<TeamPrincipal> findAllTeamPrincipalLastNames(){
        return teamPrincipalService.findAllTeamPrincipalLastNames();
   }

   @GetMapping(value = "/age/above45", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TeamPrincipal> findAllTeamPrincipalsAbove45(){
        return teamPrincipalService.findAllTeamPrincipalsAbove45();
   }

   @GetMapping(value = "/firstname/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamPrincipal findTeamPrincipalByFirstName(@PathVariable String firstName){
        return teamPrincipalService.findTeamPrincipalsByFirstName(firstName);
   }

   @GetMapping(value = "/age/nationality/{age}/{nationality}", produces = MediaType.APPLICATION_JSON_VALUE)
   public TeamPrincipal findTeamPrincipalsByAgeAndNationality(@PathVariable Integer age, @PathVariable String nationality){
        return teamPrincipalService.findTeamPrincipalsByAgeAndNationality(age, nationality);
   }
}
