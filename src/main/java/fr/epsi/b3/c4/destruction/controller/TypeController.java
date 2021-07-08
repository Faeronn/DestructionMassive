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
import fr.epsi.b3.c4.destruction.model.Type;
import fr.epsi.b3.c4.destruction.service.TypeService;

@RestController
@RequestMapping("/api/types")
public class TypeController {

	@Autowired
	private TypeService service;
	
	
	@GetMapping
	public List<Type> findAll() {
		return service.findAll();
	}
	
	@GetMapping("deliveryType/{type}")
	public List<Type> findAllByDeliveryType(@PathVariable("type") Manufacturer.DeliveryType deliveryType) {
		return service.findAllByDeliveryType(deliveryType);
	}
	
	@GetMapping("{id}")
	public Type findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	
	@PutMapping("{id}")
    public Type update(@PathVariable("id") Long id, @RequestBody Type type) {
		Type t = service.findById(id);
		if(t != null) {
			t.setLabel(type.getLabel());
			return service.update(t);
		}
		else {
			return null;
		}
    }
	@PostMapping
	public Type create(@RequestBody Type type) {
		return service.create(type);
	}
	
	@PutMapping
    public Type update(@RequestBody Type type){
		
        return service.update(type);
    }
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
