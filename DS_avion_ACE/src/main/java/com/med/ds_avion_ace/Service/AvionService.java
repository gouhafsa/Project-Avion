package com.med.ds_avion_ace.Service;

import com.med.ds_avion_ace.Entity.Avion;
import com.med.ds_avion_ace.Repository.AvionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AvionService {
    List<Avion> findAll();
    List<Avion> findByModel(String model);
    List<Avion> findByModelAndPrice(String model, double price);
    Avion save(Avion avion);
    boolean deleteByMatricul(String matricul);
    Avion findByMatricul(String matricul);
}
