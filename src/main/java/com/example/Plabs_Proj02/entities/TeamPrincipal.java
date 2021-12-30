package com.example.Plabs_Proj02.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;
import com.example.Plabs_Proj02.entities.Team;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "refTeamPrincipalId", scope = TeamPrincipal.class)
@Table(name = "Team_principal")
public class TeamPrincipal {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name="id")
    private Integer teamPrincipalId;

    @Column(name = "first_name",nullable = false)
    private String teamPrincipalFirstName;

    @Column(name = "last_name",nullable = false,unique = true)
    private String teamPrincipalLastName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team",referencedColumnName = "name")
    private Team teamPrincipalTeam;

    @Column(name = "age")
    private Integer teamPrincipalAge;

    @Column(name = "nationality")
    private String teamPrincipalNationality;

    @Column(length =  1000)
    private DateTime teamPrincipalDate;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "TEAM_PRINCIPAL_team",
            joinColumns = @JoinColumn(name = "teamPrincipal_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Team team;

    public TeamPrincipal(){}

    public TeamPrincipal(String teamPrincipalFirstName, String teamPrincipalLastName, Integer teamPrincipalAge, String teamPrincipalNationality, DateTime teamPrincipalDate){
        this.teamPrincipalFirstName = teamPrincipalFirstName;
        this.teamPrincipalLastName = teamPrincipalLastName;
        this.teamPrincipalAge = teamPrincipalAge;
        this.teamPrincipalNationality = teamPrincipalNationality;
        this.teamPrincipalDate = teamPrincipalDate;
    }

    public Team getTeamPrincipalTeam() {
        return teamPrincipalTeam;
    }

    public void setTeamPrincipalTeam(Team teamPrincipalTeam) {
        this.teamPrincipalTeam = teamPrincipalTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeamPrincipalId() {
        return teamPrincipalId;
    }

    public void setTeamPrincipalId(Integer teamPrincipalId) {
        this.teamPrincipalId = teamPrincipalId;
    }

    public String getTeamPrincipalFirstName() {
        return teamPrincipalFirstName;
    }

    public void setTeamPrincipalFirstName(String teamPrincipalFirstName) {
        this.teamPrincipalFirstName = teamPrincipalFirstName;
    }

    public String getTeamPrincipalLastName() {
        return teamPrincipalLastName;
    }

    public void setTeamPrincipalLastName(String teamPrincipalLastName) {
        this.teamPrincipalLastName = teamPrincipalLastName;
    }

    public int getTeamPrincipalAge() {
        return teamPrincipalAge;
    }

    public void setTeamPrincipalAge(Integer teamPrincipalAge) {
        this.teamPrincipalAge = teamPrincipalAge;
    }

    public String getTeamPrincipalNationality() {
        return teamPrincipalNationality;
    }

    public void setTeamPrincipalNationality(String teamPrincipalNationality) {
        this.teamPrincipalNationality = teamPrincipalNationality;
    }

    public DateTime getTeamPrincipalDate() {
        return teamPrincipalDate;
    }

    public void setTeamPrincipalDate(DateTime teamPrincipalDate) {
        this.teamPrincipalDate = teamPrincipalDate;
    }
}
