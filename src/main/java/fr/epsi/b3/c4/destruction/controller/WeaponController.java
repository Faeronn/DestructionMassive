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

import fr.epsi.b3.c4.destruction.model.Weapon;
import fr.epsi.b3.c4.destruction.service.WeaponService;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {

	@Autowired
	private WeaponService service;
	
	
	@GetMapping
	public List<Weapon> findAll() {
		return service.findAll();
	}
	
	@GetMapping("eff/{eff}")
	public List<Weapon> findAllByEfficiencyGreaterThan(@PathVariable("eff") int efficiency) {
		return service.findAllByEfficiencyGreaterThan(efficiency);
	}
	
	@GetMapping("{id}")
	public Weapon findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Weapon create(@RequestBody Weapon weapon) {
		return service.create(weapon);
	}
	
	@PutMapping
    public Weapon update(@RequestBody Weapon weapon){
        return service.update(weapon);
    }
	
	@PutMapping("{id}")
    public Weapon update(@PathVariable("id") Long id, @RequestBody Weapon weapon) {
		Weapon w = service.findById(id);
		if(w != null) {
			w.setEfficiency(weapon.getEfficiency());
			w.setManufacturer(weapon.getManufacturer());
			w.setName(weapon.getName());
			w.setType(weapon.getType());
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
