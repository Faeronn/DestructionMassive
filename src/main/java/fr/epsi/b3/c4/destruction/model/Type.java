package fr.epsi.b3.c4.destruction.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	
	@JsonIgnore
	@OneToMany(mappedBy = "type")
    private Set<Weapon> weaponSet;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	public Set<Weapon> getWeaponSet() {
		return weaponSet;
	}
	public void setWeaponSet(Set<Weapon> weaponSet) {
		this.weaponSet = weaponSet;
	}
}
