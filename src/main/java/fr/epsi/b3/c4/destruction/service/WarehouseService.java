package fr.epsi.b3.c4.destruction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.b3.c4.destruction.model.Warehouse;
import fr.epsi.b3.c4.destruction.repository.WarehouseRepository;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository repository;
	
	public List<Warehouse> findAll() {
		return repository.findAll();
	}
	
	public Warehouse findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Warehouse create(Warehouse warehouse) {
		return repository.save(warehouse);
	}
	
	public Warehouse update(Warehouse warehouse) {
		return repository.save(warehouse);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
