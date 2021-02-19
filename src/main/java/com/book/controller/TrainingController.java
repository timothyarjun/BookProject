package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Trainee;
import com.book.entity.Trainer;
import com.book.repository.TraineeRepo;
import com.book.repository.TrainerRepo;

@RestController
@RequestMapping("/api")
public class TrainingController {
	@Autowired
	private TrainerRepo trainerRepo;
	
	@Autowired
	private TraineeRepo traineeRepo;
	
	@PostMapping("/trainer")
	public String trainerSave(@RequestBody Trainer trainer) {
		return trainerRepo.save(trainer).toString();
	}
	
	@PostMapping("/trainee")
	public String traineeSave(@RequestBody Trainee trainee) {
		return traineeRepo.save(trainee).toString();
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name, @RequestParam String password) {
		Trainer t=trainerRepo.findByName(name);
		System.out.println(t);
		if(t.getPassword().equals(password)) {
			return "Login Success";
		}
		return "Login Failed";
	}
}
