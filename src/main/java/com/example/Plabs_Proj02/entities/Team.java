package com.example.Plabs_Proj02.entities;

import com.example.Plabs_Proj02.entities.Driver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "refTeamId", scope = Team.class)
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name = "id")
    private Integer teamId;

    @Column(name = "name",nullable = false,unique = true)
    private String teamName;

    @Column(name = "engine_supplier")
    private String teamEngineSupplier;

    @Column(name = "localization")
    private String teamLocalization;

    @Column(name = "year_found")
    private Integer teamYearFound;

    @Column(length = 1000)
    private DateTime teamDate;

    @OneToOne(mappedBy = "team")
    private TeamPrincipal teamPrincipal;

    @OneToMany
    @JoinColumn(name = "name")
    Set<Driver> teamDriver = new HashSet<>();

    public Team(){}

    public Team(String teamName, String teamEngineSupplier, String teamLocalization, Integer teamYearFound, DateTime teamDate){
        this.teamName = teamName;
        this.teamEngineSupplier = teamEngineSupplier;
        this.teamLocalization = teamLocalization;
        this.teamYearFound = teamYearFound;
        this.teamDate = teamDate;
    }

    public void setTeamDriver(Set<Driver> teamDriver) {
        this.teamDriver = teamDriver;
    }

    public TeamPrincipal getTeamPrincipal() {
        return teamPrincipal;
    }

    public void setTeamPrincipal(TeamPrincipal teamPrincipal) {
        this.teamPrincipal = teamPrincipal;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamEngineSupplier() {
        return teamEngineSupplier;
    }

    public void setTeamEngineSupplier(String teamEngineSupplier) {
        this.teamEngineSupplier = teamEngineSupplier;
    }

    public String getTeamLocalization() {
        return teamLocalization;
    }

    public void setTeamLocalization(String teamLocalization) {
        this.teamLocalization = teamLocalization;
    }

    public int getTeamYearFound() {
        return teamYearFound;
    }

    public void setTeamYearFound(Integer teamYearFound) {
        this.teamYearFound = teamYearFound;
    }

    public DateTime getTeamDate() {
        return teamDate;
    }

    public void setTeamDate(DateTime teamDate) {
        this.teamDate = teamDate;
    }
}
