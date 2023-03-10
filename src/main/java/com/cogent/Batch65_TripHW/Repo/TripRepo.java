package com.cogent.Batch65_TripHW.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cogent.Batch65_TripHW.Entity.Trip;


public interface TripRepo extends JpaRepository<Trip, Long>{

//	void deleteById(long id);
//
//	Optional<Trip> findById(long id);

}
