package fr.epsi.b3.c4.destruction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.epsi.b3.c4.destruction.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
	@Query("SELECT DISTINCT(m) FROM Weapon w JOIN w.manufacturer m JOIN w.warehouseSet wh WHERE wh.country = :country")
	List<Manufacturer> findAllByCountry(@Param("country") String country);
}
