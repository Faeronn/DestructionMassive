package fr.epsi.b3.c4.destruction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.b3.c4.destruction.model.Manufacturer;
import fr.epsi.b3.c4.destruction.model.Type;
import fr.epsi.b3.c4.destruction.repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository repository;
	
	
	public List<Type> findAll() {
		return repository.findAll();
	}
	
	public List<Type> findAllByDeliveryType(Manufacturer.DeliveryType deliveryType) {
		return repository.findAllByDeliveryType(deliveryType);
	}
	
	public Type findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Type create(Type type) {
		return repository.save(type);
	}
	
	public Type update(Type type) {
		return repository.save(type);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
