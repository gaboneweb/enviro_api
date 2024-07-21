package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;
import com.enviro.assessement.bulelanigabonewe.Repositories.RecyclingTipsRepository;

@Service
public class RecyclingTipsService {

    private final RecyclingTipsRepository recyclingTipsRepository;

    @Autowired
    public RecyclingTipsService(RecyclingTipsRepository recyclingTipsRepository){
        this.recyclingTipsRepository = recyclingTipsRepository;
    }

    public Optional<RecyclingTips> getRecyclingTipsById(Long id){
        return recyclingTipsRepository.findById(id);
    }

}
