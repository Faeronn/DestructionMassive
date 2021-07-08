package fr.epsi.b3.c4.destruction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.epsi.b3.c4.destruction.model.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
	
	List<Weapon> findAllByEfficiencyGreaterThan(int efficiency);

}
