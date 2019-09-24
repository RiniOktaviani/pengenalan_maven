package coba.latihan.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coba.latihan.model.Coba;
import coba.latihan.repository.CobaRepository;


@Service
public class CobaDAO {
	@Autowired
	CobaRepository cobaRepository;
	
	//get all
	public List<Coba> getAll(){
		return cobaRepository.findAll();	
	}
	
	//find by id
	public Coba getFindOne(Long id) {
		return cobaRepository.findOne(id);
	}
	
	//save book
	public Coba save(Coba coba) {
		return cobaRepository.save(coba);
	}
	
	//delete
	public void delete(Long id) {
		cobaRepository.delete(id);
	}

}
