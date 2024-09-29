package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.simple.JdbcClient;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
@AnonymousAllowed
public class ChatAiService {
private ChatClient chatClient ;
private VectorStore vectorStore;
@Value("classpath:/prompts/prompt-template.st")
private Ressource promptRessource;
	
	public ChatAiService(ChatClient.Builder builder ,VectorStore vectorStore, JdbcClient jdbcClient) {
		this.chatClient = builder.build();
		this.vectorStore= vectorStore;
	}
	
	public String ragChat(String question) {
		List<Document> documents = vectorStore.similaritySearch(question);
		List<String> context = documents.stream().map(Document::getContext).toList();
		PromptTemplate pomptTemplate = new PromptTemplate(promptRessource);
		Prompt prompt = pomptTemplate.create(
				Map.of("context" , context , "question", question)
				);
				
		return chatClient.prompt(prompt)
				.call()
				.content();
	}

}
