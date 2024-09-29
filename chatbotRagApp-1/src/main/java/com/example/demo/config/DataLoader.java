package com.example.demo.config;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
	@Value("classpath:/pdfs/cv.pdf")
	private Ressource pdfRessource;
	@Value(" store-data-v1.json")
	private String storeFile;

	private JdbcClient jdbcClient ;
	private VectorStore vectorStore;
	
	public DataLoader(JdbcClient jdbcClient ,VectorStore vectorStore) {
		this.jdbcClient= jdbcClient;
		this.vectorStore=vectorStore;
	}
	
	//@Bean
	public SimpleVectorStore simpleVectorStore(EmbeddingModel embedding) {
		SimpleVectorStore vectorStore = new SimpleVectorStore(embedding);
		String fileStore = Path.of("src","main","ressources","store").toAbsolutePath()
	+"/" + storeFile;
		File file = new File(fileStore);
		if(!file.exists()) {
			PagePdfDocumentReader pagePdfDocumentReader = new PagePdfDocumentReader(pdfRessource);
			List<Document> documents = pagePdfDocumentReader.get();
			TextSplitter textSplitter = new TokenTextSplitter();
			List<Document> chunks = textSplitter.split(documents);
			vectorStore.accept(chunks);
			vectorStore.save(file);
		}else {
			vectorStore.load(file);
		}
		return vectorStore;
	}
	
	
	@PostConstruct
	public void initStore() {
		Integer count = jdbcClient.sql("select count(*) from vector_store")
				.query(Integer.class).single();
		if(count == 0) {
			PagePdfDocumentReader pagePdfDocumentReader = new PagePdfDocumentReader(pdfRessource);
			List<Document> documents = pagePdfDocumentReader.get();
			TextSplitter textSplitter = new TokenTextSplitter();
			List<Document> chunks = textSplitter.split(documents);
			vectorStore.add(chunks);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}

