package com.kaiburr.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
	@Autowired
	TaskRepository repo;
	@Autowired
	SearchTaskRepository srepo;
	@GetMapping("/")
	public ResponseEntity<String> homePage() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<TaskModel>> getAllTasks(){
		List<TaskModel> tasks = repo.findAll();
		if(tasks.size() != 0) {
			return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get/assignee/{assignee}")
	public ResponseEntity<List<TaskModel>> getByAssignee(@PathVariable("assignee") String assignee){
		List<TaskModel> tasks = repo.findByAssigneeOrderByStartTimeAsc(assignee);
		if(tasks.size() != 0) {
			return new ResponseEntity<List<TaskModel>>(tasks.subList(0, Math.min(10, tasks.size())), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<TaskModel>> getByName(@PathVariable("name") String name){
		List<TaskModel> tasks = srepo.searchByName(name);
		if(tasks.size() != 0) {
			return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/create")
	public TaskModel putTask(@RequestBody TaskModel request) {
		TaskModel task = new TaskModel(
                request.getId(),
                request.getName(),
                request.getAssignee(),
                request.getProject(),
                request.getStartTime()
        );
		return repo.save(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TaskModel> deleteTask(@PathVariable("id") String id) {
		TaskModel task = repo.findById(id).orElse(null);
		if(task != null) {
			repo.deleteById(id);
			return new ResponseEntity<TaskModel>(task, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<TaskModel>(task, HttpStatus.BAD_REQUEST);
		}
	}
}
