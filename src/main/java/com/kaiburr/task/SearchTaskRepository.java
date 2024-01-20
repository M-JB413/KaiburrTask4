package com.kaiburr.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchTaskRepository {
	@Autowired
	private MongoClient client;
	@Autowired
	private MongoConverter converter;
	
	public List<TaskModel> searchByName(String name){
		MongoDatabase database = client.getDatabase("kaiburr");
		MongoCollection<Document> collection = database.getCollection("tasks");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "taskName")
		    .append("text", 
		    new Document("query", name)
		    .append("path", "name"))))
		);
		
		List<TaskModel> tasks = StreamSupport.stream(result.spliterator(), false)
				.map(document -> converter.read(TaskModel.class, document))
				.collect(Collectors.toList());

		return tasks;
	}
}
