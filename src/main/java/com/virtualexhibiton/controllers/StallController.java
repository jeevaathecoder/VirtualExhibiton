package com.virtualexhibiton.controllers;

import com.virtualexhibiton.model.Stall;
import com.virtualexhibiton.response.MessageResponse;
import com.virtualexhibiton.services.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stall")
public class StallController{
	
    @Autowired
    private StallService stallService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveStall(@RequestBody Stall stall) {
    	Stall saveStall = stallService.saveStall(stall);
    	 if(saveStall==null) {
    		 return ResponseEntity.badRequest().body(new MessageResponse("Stall has not created"));
    	 }
        return  ResponseEntity.ok(new MessageResponse("Stall has created"));
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

