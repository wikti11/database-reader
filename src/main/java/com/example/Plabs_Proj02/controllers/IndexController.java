package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.entities.*;
import com.example.Plabs_Proj02.services.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    private TrackService trackService;
    @Autowired
    private TeamPrincipalService teamPrincipalService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private DriverService driverService;

    @GetMapping(value = "")
    String index(){
        return "Working paths: \n/driver \n/driver/add \n/driver/all \n/driver/delete/{integer} \n" +
                "/driver/edit \n/driver/paginated/{integer} \n/driver/lastname \n/driver/age/above30 \n" +
                "/driver/number/{integer} \n/driver/name/nationality/{string}/{string}\n\n" +
                "/result \n/result/add \n/result/all \n/result/delete/{integer} \n /result/edit \n" +
                "/result/paginated/{integer} \n/result/date \n/result/position/above10 \n" +
                "/result/position/{integer} \n/result/date/position/{string}/{integer} \n\n /team \n" +
                "/team/add \n/team/all \n /team/delete/{integer} \n/team/edit \n /team/paginated/{integer} \n" +
                "/team/name \n/team/yearfound/after1990 \n/team/enginesupplier/{string} \n" +
                "/team/localization/enginesupplier/{string}/{string} \n\n/teamprincipal \n/teamprincipal/add \n" +
                "/teamprincipal/all \n/teamprincipal/delete/{integer} \n/teamprincipal/edit \n" +
                "/teamprincipal/paginated/{integer} \n/teamprincipal/lastname \n/teamprincipal/age/above45 \n" +
                "/teamprincipal/firstname/{string} \n/teamprincipal/age/nationality/{integer}/{string} \n\n" +
                "/track \n/track/add \n/track/all \n/track/delete/{integer} \n/track/edit \n" +
                "/track/paginated/{integer} \n/track/name \n/track/length/above4000 \n" +
                "/track/yearbuilt/{integer} \n/track/country/corners/{string}/{integer}";
    }

    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel(){
        DateTime dateTime = DateTime.now();

        Team alfaRomeo = new Team("Alfa Romeo Racing Orlen", "Ferrari", "Switzerland", 1950, dateTime);
        Team alphaTauri = new Team("Scuderia AlphaTauri Honda", "Honda", "Italy", 2020, dateTime);
        Team alpine = new Team("Alpine F1 Team", "Renault", "France", 2021, dateTime);

        Driver giovinazzi = new Driver("Antonio","Giovinazzi",99,28,"Italian",dateTime);
        Driver tsunoda = new Driver("Yuki","Tsunoda",22,21,"Japanese",dateTime);
        Driver alonso = new Driver("Fernando","Alonso",14,40,"Spanish",dateTime);

        giovinazzi.setTeam(alfaRomeo);
        tsunoda.setTeam(alphaTauri);
        alonso.setTeam(alpine);

        TeamPrincipal vasseur = new TeamPrincipal("Frederic", "Vasseur", 53, "French", dateTime);
        TeamPrincipal tost = new TeamPrincipal("Franz","Tost",65,"Austrian",dateTime);
        TeamPrincipal budkowski = new TeamPrincipal("Marcin","Budkowski",44,"Polish",dateTime);

        vasseur.setTeam(alfaRomeo);
        tost.setTeam(alphaTauri);
        budkowski.setTeam(alpine);

        Track sakhir = new Track("Bahrain International Circuit", 5412, 15, 2004, "Bahrain", dateTime);
        Track imola = new Track("Autodromo Internazionale Enzo e Dino Ferrari", 4909, 19, 1953, "Italy", dateTime);
        Track algarve = new Track("Autodromo Internacional do Algarve", 4653, 15, 2008, "Portugal", dateTime);

        Result r1 = new Result("28/03/2021",12,dateTime);
        Result r2 = new Result("28/03/2021",9,dateTime);
        Result r3 = new Result("28/03/2021",19,dateTime);

        r1.setResultDriver(giovinazzi);
        r1.setResultTrack(sakhir);
        r2.setResultDriver(tsunoda);
        r2.setResultTrack(sakhir);
        r3.setResultDriver(alonso);
        r3.setResultTrack(sakhir);

        trackService.saveTrack(sakhir);
        trackService.saveTrack(imola);
        trackService.saveTrack(algarve);

        teamService.saveTeam(alfaRomeo);
        teamService.saveTeam(alphaTauri);
        teamService.saveTeam(alpine);

        driverService.saveDriver(giovinazzi);
        driverService.saveDriver(tsunoda);
        driverService.saveDriver(alonso);

        teamPrincipalService.saveTeamPrincipal(vasseur);
        teamPrincipalService.saveTeamPrincipal(tost);
        teamPrincipalService.saveTeamPrincipal(budkowski);

        resultService.saveResult(r1);
        resultService.saveResult(r2);
        resultService.saveResult(r3);

        return "Database generated.";
    }
}
