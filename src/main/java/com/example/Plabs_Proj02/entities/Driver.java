package com.example.Plabs_Proj02.entities;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Driver")
public class Driver {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name="id")
    private Integer driverId;

    @Column(name = "first_name")
    private String driverFirstName;

    @Column(name = "last_name")
    private String driverLastName;

    @Column(name = "number",nullable = false,unique = true)
    private Integer driverNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team",referencedColumnName = "name")
    private Team driverTeam;

    @Column(name = "age")
    private Integer driverAge;

    @Column(name = "nationality")
    private String driverNationality;

    @Column(length = 1000)
    private DateTime driverDate;

    @OneToMany
    @JoinColumn(name = "number")
    Set<Result> driverResult = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "name")
    private Team team;

    public Driver(){}

    public Driver(String driverFirstName, String driverLastName, Integer driverNumber, Integer driverAge, String driverNationality, DateTime driverDate){
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverNumber = driverNumber;
        this.driverAge = driverAge;
        this.driverNationality = driverNationality;
        this.driverDate = driverDate;
    }

    public Set<Result> getDriverResult() {
        return driverResult;
    }

    public void setDriverResult(Set<Result> driverResult) {
        this.driverResult = driverResult;
    }

    public Team getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(Team driverTeam) {
        this.driverTeam = driverTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    public String getDriverNationality() {
        return driverNationality;
    }

    public void setDriverNationality(String driverNationality) {
        this.driverNationality = driverNationality;
    }

    public DateTime getDriverDate() {
        return driverDate;
    }

    public void setDriverDate(DateTime driverDate) {
        this.driverDate = driverDate;
    }
}
