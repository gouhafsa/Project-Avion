package com.med.ds_avion_ace.mapper;

import com.med.ds_avion_ace.Entity.Avion;
import com.med.ds_avion_ace.dto.AvionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvionMapper {

    public AvionDTO AviontoAvionDTO(Avion avion) {
        return new AvionDTO(avion.getModel(), avion.getColor(), avion.getMatricul(), avion.getPrice());
    }

    public Avion AvionDTOtoAvion(AvionDTO avionDTO) {
        Avion avion = new Avion();
        avion.setModel(avionDTO.getModel());
        avion.setColor(avionDTO.getColor());
        avion.setMatricul(avionDTO.getMatricul());
        avion.setPrice(avionDTO.getPrice());
        return avion;
    }

    public List<AvionDTO> toDTOs(List<Avion> avions) {
        return avions.stream().map(this::AviontoAvionDTO).collect(Collectors.toList());
    }

}
