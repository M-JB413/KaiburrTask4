package com.kaiburr.task;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<TaskModel, String>{
//    List<TaskModel> searchName(String query);
	List<TaskModel> findByAssigneeOrderByStartTimeAsc(String assignee);
}

// Modify this repository only for Basic Operations.
// Complex Operations can be carried out in another file.