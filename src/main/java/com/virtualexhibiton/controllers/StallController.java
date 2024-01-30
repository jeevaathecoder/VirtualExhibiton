package com.virtualexhibiton.controllers;

import com.virtualexhibiton.model.Stall;
import com.virtualexhibiton.services.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stall")
public class StallController{
    @Autowired
    private StallService stallService;

    @PostMapping(value = "/add")
    public Stall saveStall(@RequestBody Stall stall) {
        return stallService.saveStall(stall);
    }
    @GetMapping(value = "/all")
    public List<Stall> fetchStallList() {
        return stallService.fetchStallList();
    }

    @GetMapping(value = "/{id}")
    public Stall fetchStallById(@PathVariable("id") Long stallId) {
        return stallService.fetchStallById(stallId);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStallById(@PathVariable("id") Long stallId){
        stallService.deleteStallById(stallId);
        return "Stall Deleted Sucessfully";
    }

    @PutMapping("/{id}")
    public Stall updateStall(@PathVariable("id") Long stallId, @RequestBody Stall stall){
        return stallService.updateStall(stallId,stall);
    }
}

