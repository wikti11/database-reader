package com.example.Plabs_Proj02.serviceImplementations;

import com.example.Plabs_Proj02.repositories.ResultRepository;
import com.example.Plabs_Proj02.services.ResultService;
import com.example.Plabs_Proj02.entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService{
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Optional<Result> getResultById(Integer id){
        return resultRepository.findById(id);
    }

    @Override
    public Result saveResult(Result result){
        return resultRepository.save(result);
    }

    @Override
    public void deleteResult(Integer id){
        resultRepository.deleteById(id);
    }

    public Iterable<Result> findAllResultsWithPagination (Integer pageNr, Integer amountOnPage){
        return resultRepository.findAll(PageRequest.of(pageNr, amountOnPage));
    }

    public Collection<Result> findAllResultDates (){
        return resultRepository.findAllResultDates();
    }

    public Collection<Result> findResultsPositionAbove10(){
        return resultRepository.findResultsPositionAbove10();
    }

    public Result findResultsByPosition(Integer position){
        return resultRepository.findResultsByPosition(position);
    }

    public Result findResultsByDateAndPosition(String date, Integer position){
        return resultRepository.findResultsByDateAndPosition(date, position);
    }
}
