package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ChatAiService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	private ChatAiService chatService ; 

	public ChatController(ChatAiService chatService) {
		this.chatService= chatService;
	}

	@GetMapping("/ask")
	public String ask(String question) {
		return chatService.ragChat(question);
	}

}
