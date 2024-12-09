package com.med.ds_avion_ace.Repository;

import com.med.ds_avion_ace.Entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvionRepository extends JpaRepository<Avion, Long> {
    List<Avion> findByModel(String model);
    List<Avion> findByModelAndPrice(String model, double price);
    Optional<Avion> findByMatricul(String matricul);
}
