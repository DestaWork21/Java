package com.project.beltreview.repositories;

import com.project.beltreview.models.Event;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface EventRepository extends CrudRepository<Event,Long>{
	ArrayList<Event> findAll();
	ArrayList<Event> findByState(String state);
	// @Query(value="SELECT * FROM events WERE state != ?1", nativeQuery=true)
	// ArrayList<Event> findNotByState(String state);
}
