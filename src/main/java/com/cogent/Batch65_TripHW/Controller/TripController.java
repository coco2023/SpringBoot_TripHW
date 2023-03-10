package com.cogent.Batch65_TripHW.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.Batch65_TripHW.Entity.Trip;
import com.cogent.Batch65_TripHW.Repo.TripRepo;

@RestController
public class TripController {
	
	@Autowired
	TripRepo tripRepo;
	
	@GetMapping("/gettrip")
	public List<Trip> getTrip(){
		System.out.println("Show all Trips!");
		return tripRepo.findAll();
	}
	
	@PostMapping("/addtrip")
	public Trip addTrip(@Valid  @RequestBody Trip newTrip) {
		return tripRepo.save(newTrip);		
	}
	
	@PutMapping("/updatetrip/{id}")
	public ResponseEntity<Trip> updateTrip(@PathVariable("id") long id, @RequestBody Trip newTrip){
		Optional<Trip> existingTrip = tripRepo.findById(id);
		if (existingTrip.isPresent()) {
			Trip tempTrip = existingTrip.get();
			
			tempTrip.setId(newTrip.getId());
			tempTrip.setName(newTrip.getName());
			tempTrip.setVeg(newTrip.isVeg());
			tempTrip.setKids(newTrip.getKids());
			
			return new ResponseEntity<>(tripRepo.save(tempTrip), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
	}
	
	@DeleteMapping("/deltrip/{id}")
	public void deleteTrip(@PathVariable("id") long id) {
		tripRepo.deleteById(id);
		System.out.println("Success Delete!!!");
	}
	

}
