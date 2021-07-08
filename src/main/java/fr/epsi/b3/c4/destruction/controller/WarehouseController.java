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

import fr.epsi.b3.c4.destruction.model.Warehouse;
import fr.epsi.b3.c4.destruction.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
	
	@Autowired
	private WarehouseService service;
	
	
	@GetMapping
	public List<Warehouse> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Warehouse findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Warehouse create(@RequestBody Warehouse warehouse) {
		return service.create(warehouse);
	}
	
	@PutMapping("{id}")
    public Warehouse update(@PathVariable("id") Long id, @RequestBody Warehouse warehouse) {
		Warehouse w = service.findById(id);
		if(w != null) {
			w.setCountry(warehouse.getCountry());
			w.setLatitude(warehouse.getLatitude());
			w.setLongitude(warehouse.getLongitude());
			w.setQuantity(warehouse.getQuantity());
			return service.update(w);
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
