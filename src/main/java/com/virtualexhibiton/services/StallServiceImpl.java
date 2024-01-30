package com.virtualexhibiton.services;

import com.virtualexhibiton.model.Stall;
import com.virtualexhibiton.repository.StallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StallServiceImpl implements StallService{

   @Autowired
   private StallRepository stallRepository;

    @Override
    public Stall saveStall(Stall stall) {
        return stallRepository.save(stall);
    }

    @Override
    public List<Stall> fetchStallList() {
        return stallRepository.findAll();
    }

    @Override
    public Stall fetchStallById(Long stallId) {
        return stallRepository.findById(stallId).get();
    }

    @Override
    public void deleteStallById(Long stallId) {
        stallRepository.deleteById(stallId);
    }

    @Override
    public Stall updateStall(Long stallId, Stall stall) {
        Stall stallDB = stallRepository.findById(stallId).get();

        if(Objects.nonNull(stall.getStallName()) &&
                !"" .equalsIgnoreCase(stall.getStallName())){
            stallDB.setStallName(stall.getStallName());
        }

        if(Objects.nonNull(stall.getStallDescription()) &&
                !"" .equalsIgnoreCase(stall.getStallDescription())){
            stallDB.setStallDescription(stall.getStallDescription());
        }


        if(Objects.nonNull(stall.getPhotoUrl()) &&
                !"" .equalsIgnoreCase(stall.getPhotoUrl())){
            stallDB.setPhotoUrl(stall.getPhotoUrl());
        }

        if(Objects.nonNull(stall.getVideoUrl()) &&
                !"" .equalsIgnoreCase(stall.getVideoUrl())){
            stallDB.setVideoUrl(stall.getVideoUrl());
        }

        if(Objects.nonNull(stall.getBrochureUrl()) &&
                !"" .equalsIgnoreCase(stall.getBrochureUrl())){
            stallDB.setBrochureUrl(stall.getBrochureUrl());
        }


        return stallRepository.save(stallDB);
    }


}
