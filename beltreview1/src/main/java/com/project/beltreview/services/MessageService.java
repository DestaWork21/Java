package com.project.beltreview.services;

import com.project.beltreview.models.Message;
import com.project.beltreview.repositories.MessageRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;

    }
    public void create(Message message){
        messageRepository.save(message);
    }
    public ArrayList<Message> all(){
        return messageRepository.findAll();
    }
    public Message findById(long id){
        return messageRepository.findOne(id);
    }
    public void update(Message message){
        create(message);
    }
    public void destroy (long id){
        messageRepository.delete(id);
    }

}