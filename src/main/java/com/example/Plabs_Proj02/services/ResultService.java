package com.example.Plabs_Proj02.services;

import com.example.Plabs_Proj02.entities.Result;

import java.util.Collection;
import java.util.Optional;

public interface ResultService {
    Result saveResult(Result result);

    void deleteResult(Integer id);

    Optional<Result> getResultById(Integer id);

    Iterable<Result> findAllResultsWithPagination(Integer pageNr, Integer amountOnPage);

    Collection<Result> findAllResultDates();

    Collection<Result> findResultsPositionAbove10();

    Result findResultsByPosition(Integer position);

    Result findResultsByDateAndPosition(String date, Integer position);
}
