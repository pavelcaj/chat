package com.example.chat.servise;
import com.example.chat.chat.ChatMessage;
import com.example.chat.rep.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<ChatMessage> getAllMessages() {
        return messageRepository.findAll();
    }

    public ChatMessage getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public ChatMessage saveMessage(ChatMessage message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}