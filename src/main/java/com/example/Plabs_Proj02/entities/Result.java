package com.example.Plabs_Proj02.entities;

import com.example.Plabs_Proj02.entities.Driver;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "Result")
public class Result {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name="id")
    private Integer resultId;

    @Column(name = "date", nullable = false)
    private String resultDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name", nullable = false)
    private Track resultTrack;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "number", nullable = false)
    private Driver resultDriver;

    @Column(name = "position")
    private Integer resultPosition;

    @Column(length = 1000)
    private DateTime resultDateTime;

    public Result() {
    }

    public Result(String resultDate, Integer resultPosition, DateTime resultDateTime) {
        this.resultDate = resultDate;
        this.resultPosition = resultPosition;
        this.resultDateTime = resultDateTime;
    }

    public Track getResultTrack() {
        return resultTrack;
    }

    public void setResultTrack(Track resultTrack) {
        this.resultTrack = resultTrack;
    }

    public Driver getResultDriver() {
        return resultDriver;
    }

    public void setResultDriver(Driver resultDriver) {
        this.resultDriver = resultDriver;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public int getResultPosition() {
        return resultPosition;
    }

    public void setResultPosition(Integer resultPosition) {
        this.resultPosition = resultPosition;
    }

    public DateTime getResultDateTime() {
        return resultDateTime;
    }

    public void setResultDateTime(DateTime resultDateTime) {
        this.resultDateTime = resultDateTime;
    }
}


