package fr.epsi.b3.c4.destruction.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String reputation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "manufacturer")
    private Set<Weapon> weaponSet;
	
	@Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
	
	
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
	
	
	public String getReputation() {
		return reputation;
	}
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
	
	
	public Set<Weapon> getWeaponSet() {
		return weaponSet;
	}
	public void setWeaponSet(Set<Weapon> weaponSet) {
		this.weaponSet = weaponSet;
	}
	
	
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	public enum DeliveryType {
	    UBERBOMB,
	    LAPOSTE
	}
}
