package com.cogent.Batch65_TripHW.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cogent.Batch65_TripHW.Entity.Trip;
import com.cogent.Batch65_TripHW.Repo.TripRepo;

@Service
public class TripService {
	@Autowired
	TripRepo tripRepo;
	
	public Trip getTrip(long id) {
		return tripRepo.findById(id).get();
	}
	
	public List<Trip> getAllTrip(){
		List<Trip> trips = new ArrayList<Trip>();
		tripRepo.findAll().forEach(trip -> trips.add(trip));
		
		return trips;
		}
	
	public void saveOrUpdate(Trip trip) {
		tripRepo.save(trip);
	}
	
	public void deleteTrip(long id) {
		tripRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
