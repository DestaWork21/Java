package com.project.beltreview.services;
import com.project.beltreview.models.Event;
import com.project.beltreview.repositories.EventRepository;
import java.util.ArrayList;


import org.springframework.stereotype.Service;

@Service
public class EventService {
    public EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
        
    }
    public void create(Event event){
        eventRepository.save(event);
    }
    public ArrayList<Event> all(){
        return eventRepository.findAll();
    }
    public Event findById(long id){
        return eventRepository.findOne(id);
    }
    public void update(Event event){
        create(event);
    }
    public void destroy (long id){
        eventRepository.delete(id);
    }

    public ArrayList<Event> findByState(String state){
        return (ArrayList<Event>)eventRepository.findByState(state);
    }
    

}
