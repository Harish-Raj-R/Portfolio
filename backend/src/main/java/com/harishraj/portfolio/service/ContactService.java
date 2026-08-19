package com.harishraj.portfolio.service;

import com.harishraj.portfolio.model.ContactMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ContactService {

    private final List<ContactMessage> messages = new CopyOnWriteArrayList<>();

    public ContactMessage saveMessage(ContactMessage message) {
        message.setId(UUID.randomUUID().toString().substring(0, 8));
        messages.add(0, message);
        return message;
    }

    public List<ContactMessage> getAllMessages() {
        return messages;
    }
}
