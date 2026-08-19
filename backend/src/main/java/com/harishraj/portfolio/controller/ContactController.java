package com.harishraj.portfolio.controller;

import com.harishraj.portfolio.model.ContactMessage;
import com.harishraj.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> submitMessage(@Valid @RequestBody ContactMessage message, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "ERROR",
                    "errors", errors
            ));
        }

        ContactMessage saved = contactService.saveMessage(message);
        return ResponseEntity.ok(Map.of(
                "status", "SUCCESS",
                "message", "Thank you, " + saved.getName() + "! Your message has been received by Harish Raj R.",
                "messageId", saved.getId(),
                "timestamp", saved.getSubmittedAt().toString()
        ));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactMessage>> getMessages() {
        return ResponseEntity.ok(contactService.getAllMessages());
    }
}
