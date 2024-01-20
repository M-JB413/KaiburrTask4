package com.kaiburr.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Random;

@Document(collection = "tasks")
public class TaskModel {
    @Id
    private String id;
    private String name;
    private String assignee;
    private String project;
    private Instant startTime;
    private String jiettheshBalajiProperty;
    
    private static final String candidate = "JiettheshBalaji";

    public TaskModel() {
        // Default constructor
    }

    public TaskModel(String id, String name, String assignee, String project, Instant startTime) {
        this.id = id;
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.startTime = startTime;
        this.jiettheshBalajiProperty = generateRandomString();
    }
    
    private String generateRandomString() {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(candidate.length());
            char randomChar = candidate.charAt(randomIndex);
            randomString.append(randomChar);
        }
        
        return randomString.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }
    
	public String getJiettheshBalajiProperty() {
		return jiettheshBalajiProperty;
	}

	public void setJiettheshBalajiProperty(String jiettheshBalajiProperty) {
		this.jiettheshBalajiProperty = jiettheshBalajiProperty;
	}

    @Override
    public String toString() {
        return "TaskModel [id=" + id + ", name=" + name + ", assignee=" + assignee + ", project=" + project
                + ", startTime=" + startTime + "]";
    }
}
