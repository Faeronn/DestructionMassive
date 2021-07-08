package fr.epsi.b3.c4.destruction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.b3.c4.destruction.model.Weapon;
import fr.epsi.b3.c4.destruction.repository.WeaponRepository;

@Service
public class WeaponService {
	
	@Autowired
	private WeaponRepository repository;
	
	
	public List<Weapon> findAllByEfficiencyGreaterThan(int efficiency) {
		return repository.findAllByEfficiencyGreaterThan(efficiency);
	}
	
	public List<Weapon> findAll() {
		return repository.findAll();
	}
	
	public Weapon findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Weapon create(Weapon weapon) {
		return repository.save(weapon);
	}
	
	public Weapon update(Weapon weapon) {
		return repository.save(weapon);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
