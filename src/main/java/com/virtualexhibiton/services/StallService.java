package com.virtualexhibiton.services;

import com.virtualexhibiton.model.Stall;

import java.util.List;

public interface StallService {
    public Stall saveStall(Stall stall);

    public List<Stall> fetchStallList();

    public Stall fetchStallById(Long stallId);

    public void deleteStallById(Long stallId);

    Stall updateStall(Long stallId, Stall stall);
}
