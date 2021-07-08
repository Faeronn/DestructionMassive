package fr.epsi.b3.c4.destruction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.epsi.b3.c4.destruction.model.Manufacturer;
import fr.epsi.b3.c4.destruction.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
	@Query("SELECT DISTINCT(t) FROM Weapon w JOIN w.type t JOIN w.manufacturer m WHERE m.deliveryType = :deliveryType")
    List<Type> findAllByDeliveryType(@Param("deliveryType") Manufacturer.DeliveryType deliveryType);
}
