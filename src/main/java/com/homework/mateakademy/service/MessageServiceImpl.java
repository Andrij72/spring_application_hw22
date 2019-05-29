package com.homework.mateakademy.service;

import com.homework.mateakademy.domain.Message;
import com.homework.mateakademy.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getByTag(String tag) {
        return messageRepository.findByTag(tag);
    }

    @Override
    public void saveMessage(Message message) {

    }

    @Override
    public List <Message> findAllMessage() {
        return (List<Message>) messageRepository.findAll();
    }
}
