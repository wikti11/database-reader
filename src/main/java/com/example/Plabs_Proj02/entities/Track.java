package com.example.Plabs_Proj02.entities;

import com.example.Plabs_Proj02.entities.Result;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Track")
public class Track {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name="id")
    private Integer trackId;

    @Column(name = "name",nullable = false,unique = true)
    private String trackName;

    @Column(name = "length",nullable = false)
    private Integer trackLength;

    @Column(name = "amount_of_corners",nullable = false)
    private Integer trackCorners;

    @Column(name = "year_built")
    private Integer trackYearBuilt;

    @Column(name = "country")
    private String trackCountry;

    @Column(length = 1000)
    private DateTime trackDateTime;

    @OneToMany
    @JoinColumn(name = "name")
    Set<Result> result = new HashSet<>();

    public Track(){}

    public Track(String trackName, Integer trackLength, Integer trackCorners, Integer trackYearBuilt, String trackCountry, DateTime trackDateTime){
        this.trackName = trackName;
        this.trackLength = trackLength;
        this.trackCorners = trackCorners;
        this.trackYearBuilt = trackYearBuilt;
        this.trackCountry = trackCountry;
        this.trackDateTime = trackDateTime;
    }

    public Set<Result> getResult() {
        return result;
    }

    public void setResult(Set<Result> result) {
        this.result = result;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(Integer trackLength) {
        this.trackLength = trackLength;
    }

    public Integer getTrackCorners() {
        return trackCorners;
    }

    public void setTrackCorners(Integer trackCorners) {
        this.trackCorners = trackCorners;
    }

    public Integer getTrackYearBuilt() {
        return trackYearBuilt;
    }

    public void setTrackYearBuilt(Integer trackYearBuilt) {
        this.trackYearBuilt = trackYearBuilt;
    }

    public String getTrackCountry() {
        return trackCountry;
    }

    public void setTrackCountry(String trackCountry) {
        this.trackCountry = trackCountry;
    }

    public DateTime getTrackDateTime() {
        return trackDateTime;
    }

    public void setTrackDateTime(DateTime trackDateTime) {
        this.trackDateTime = trackDateTime;
    }
}
