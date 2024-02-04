package com.virtualexhibiton.services;

import com.virtualexhibiton.model.Stall;
import com.virtualexhibiton.response.StallResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StallService{

	StallResponse saveStall(@Valid Stall stall);

	List<Stall> fetchStallList();

	Stall fetchStallById(Long stallId);

	void deleteStallById(Long stallId);

	Stall updateStall(Long stallId, Stall stall);
	

}
