package fr.epsi.b3.c4.destruction.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Weapon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int efficiency;
	
	@ManyToOne
    private Manufacturer manufacturer;
	
	@ManyToOne
    private Type type;
	
	@ManyToMany
    private Set<Warehouse> warehouseSet;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	public Set<Warehouse> getWarehouseSet() {
		return warehouseSet;
	}
	public void setWarehouseSet(Set<Warehouse> warehouseSet) {
		this.warehouseSet = warehouseSet;
	}

}
