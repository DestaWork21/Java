package com.project.dojosandninjas.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojosandninjas.models.Ninja;

@Repository 												
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	
}
