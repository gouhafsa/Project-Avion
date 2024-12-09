package com.med.ds_avion_ace.Service;

import com.med.ds_avion_ace.Entity.Avion;
import com.med.ds_avion_ace.Repository.AvionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvionServiceAction implements AvionService{

    private final AvionRepository avionRepository;

    @Override
    public List<Avion> findAll() {
        return avionRepository.findAll();
    }

    @Override
    public List<Avion> findByModel(String model) {
        return avionRepository.findByModel(model);
    }

    @Override
    public List<Avion> findByModelAndPrice(String model, double price) {
        return avionRepository.findByModelAndPrice(model, price);
    }

    @Override
    public Avion save(Avion avion) {
        Optional<Avion> existingAvion = avionRepository.findByMatricul(avion.getMatricul());
        if (existingAvion.isPresent()) {
            throw new IllegalArgumentException("Matricul already exists.");
        }
        return avionRepository.save(avion);
    }

    @Override
    public boolean deleteByMatricul(String matricul) {
        Optional<Avion> existingAvion = avionRepository.findByMatricul(matricul);
        if (existingAvion.isPresent()) {
            avionRepository.delete(existingAvion.get());
            return true;
        }
        return false;
    }

    @Override
    public Avion findByMatricul(String matricul) {
        return avionRepository.findByMatricul(matricul).orElseThrow(() ->
                new IllegalArgumentException("Avion not found with matricul: " + matricul));
    }
}
