package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Hus_WifeDTO;
import com.book.entity.Husband;
import com.book.entity.Wife;
import com.book.repository.HusbandRepo;
import com.book.repository.WifeRepo;

@Service
public class HusbandService {
	private HusbandRepo husbandRepo;
	private WifeRepo wifeRepo;
	
	@Autowired
	public HusbandService(HusbandRepo husbandRepo, WifeRepo wifeRepo) {
		super();
		this.husbandRepo = husbandRepo;
		this.wifeRepo = wifeRepo;
	}
	
	public Husband registerHusband(Husband husband) {
		husband.getWife().getHusband();
		return husbandRepo.save(husband);
	}
	
	public Wife registerWife(Wife wife) {
		return wifeRepo.save(wife);
	}
	
	public List<Husband> getAll(){
		return husbandRepo.findAll();
	}
	
	public List<Wife> findAll(){
		return wifeRepo.findAll();
	}
	
	public Husband findOne(Long id) {
		return husbandRepo.getOne(id);
	}
	
	public Wife getWife(Long id) {
		return wifeRepo.getOne(id);
	}

}
