package com.homework.mateakademy.service;

import com.homework.mateakademy.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> getByTag(String tag);

    void saveMessage(Message message);

    List<Message> findAllMessage();
}
