package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Hus_WifeDTO;
import com.book.entity.Husband;
import com.book.entity.Wife;
import com.book.service.HusbandService;

@RestController
@RequestMapping("/api")
public class HusbandController {
	private HusbandService husbandService;

	@Autowired
	public HusbandController(HusbandService husbandService) {
		super();
		this.husbandService = husbandService;
	}

	@PostMapping("/hus/add")
	public Husband registerHusband(@RequestBody Husband husband) {
		return husbandService.registerHusband(husband);
	}
	
	@PostMapping("/wife/add")
	public Wife registerWife(@RequestBody Wife wife) {
		return husbandService.registerWife(wife);
	}
	
	@GetMapping("/all/hus")
	public List<Husband> listAll(){
		return husbandService.getAll();
	}
	
	@GetMapping("/all/wife")
	public List<Wife> findAll(){
		return husbandService.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Husband getOne(@PathVariable Long id) {
		return husbandService.findOne(id);
	}
	
	@GetMapping("/getwife/{id}")
	public Wife getWife(@PathVariable Long id) {
		return husbandService.getWife(id);
	}
	
	
}
