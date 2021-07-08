package fr.epsi.b3.c4.destruction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.b3.c4.destruction.model.Manufacturer;
import fr.epsi.b3.c4.destruction.repository.ManufacturerRepository;

@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository repository;
	
	public List<Manufacturer> findAll() {
		return repository.findAll();
	}
	
	public List<Manufacturer> findAllByCountry(String country) {
		return repository.findAllByCountry(country);
	}
	
	public Manufacturer findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Manufacturer create(Manufacturer manufacturer) {
		return repository.save(manufacturer);
	}
	
	public Manufacturer update(Manufacturer manufacturer) {
		return repository.save(manufacturer);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
