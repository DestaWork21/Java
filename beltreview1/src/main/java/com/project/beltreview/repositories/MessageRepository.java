package com.project.beltreview.repositories;

import com.project.beltreview.models.Message;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface MessageRepository extends CrudRepository<Message,Long>{
	ArrayList<Message> findAll();
}
