package com.example.chat.rep;

import com.example.chat.chat.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
}
