package fr.epsi.b3.c4.destruction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.b3.c4.destruction.model.Manufacturer;
import fr.epsi.b3.c4.destruction.service.ManufacturerService;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService service;
	
	
	@GetMapping
	public List<Manufacturer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("country/{country}")
	public List<Manufacturer> findAllByCountry(@PathVariable("country") String country) {
		return service.findAllByCountry(country);
	}
	
	@GetMapping("{id}")
	public Manufacturer findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping()
	public Manufacturer create(@RequestBody Manufacturer manufacturer) {
		return service.create(manufacturer);
	}
	
	@PutMapping("{id}")
    public Manufacturer update(@PathVariable("id") Long id, @RequestBody Manufacturer manufacturer) {
		Manufacturer m = service.findById(id);
		if(m != null) {
			m.setName(manufacturer.getName());
			m.setReputation(manufacturer.getReputation());
			return service.update(m);
		}
		else {
			return null;
		}
    }
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
