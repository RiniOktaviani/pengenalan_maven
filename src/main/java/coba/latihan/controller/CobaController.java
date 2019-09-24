package coba.latihan.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coba.latihan.dao.CobaDAO;
import coba.latihan.model.Coba;


@RestController
@RequestMapping("/ok")
public class CobaController {
	@Autowired
	CobaDAO cobaDAO;
	
	//for save
	@PostMapping("/coba")
	public Coba saveCoba(@Valid @RequestBody Coba coba) {
		return cobaDAO.save(coba);
	}
	
	//for get all
	@GetMapping("/coba")
	public List<Coba> getAllBook(){
		return cobaDAO.getAll();
	}
	
	//get one by id
	@GetMapping("/coba/{id}")
	public ResponseEntity<Coba> getCobaById(@PathVariable(value="id")Long id) {
		Coba b=cobaDAO.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(b);
		}
	}
	
	// for update
	@PutMapping("/coba/{id}")
	public ResponseEntity<Coba> updateCoba(@PathVariable(value="id")Long id,@Valid @RequestBody Coba coba){
		Coba b=cobaDAO.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			
			b.setJurusan(coba.getJurusan());
			
			b.setNama(coba.getNama());
			
			Coba bResult=cobaDAO.save(b);
			return ResponseEntity.ok().body(bResult);
		}
		
	}
	
	// for delete
	@DeleteMapping("/coba/{id}")
	public ResponseEntity<Coba> deleteCoba(@PathVariable(value="id")Long id){
		Coba b=cobaDAO.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			cobaDAO.delete(id);
			 return ResponseEntity.ok().build();
			
		}
	}
	
	

}
