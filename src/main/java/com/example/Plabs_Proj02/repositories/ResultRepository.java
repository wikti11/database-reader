package com.example.Plabs_Proj02.repositories;

import com.example.Plabs_Proj02.entities.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface ResultRepository extends CrudRepository<Result, Integer>, PagingAndSortingRepository<Result, Integer> {

    @Query("SELECT r.date FROM Result r")
    Collection<Result> findAllResultDates();

    @Query("SELECT r FROM Result r WHERE r.position > 10")
    Collection<Result> findResultsPositionAbove10();

    @Query("SELECT r FROM Result r WHERE r.position = ?1")
    Result findResultsByPosition(Integer position);

    @Query("SELECT r FROM Result r WHERE r.date = ?1 and r.position = ?2")
    Result findResultsByDateAndPosition(String date, Integer position);
}
