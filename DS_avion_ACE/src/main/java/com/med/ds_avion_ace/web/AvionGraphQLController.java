package com.med.ds_avion_ace.web;

import com.med.ds_avion_ace.Service.AvionService;
import com.med.ds_avion_ace.dto.AvionDTO;
import com.med.ds_avion_ace.mapper.AvionMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AvionGraphQLController {

    private final AvionService avionService;
    private final AvionMapper avionMapper;

    public AvionGraphQLController(AvionService avionService, AvionMapper avionMapper) {
        this.avionService = avionService;
        this.avionMapper = avionMapper;
    }

    // Query to fetch all avions
    @QueryMapping
    public List<AvionDTO> getAllAvions() {
        return avionMapper.toDTOs(avionService.findAll());
    }

    // Query to fetch avions by model
    @QueryMapping
    public List<AvionDTO> getAvionByModel(@Argument String model) {
        return avionMapper.toDTOs(avionService.findByModel(model));
    }

    // Query to fetch avions by model and price
    @QueryMapping
    public List<AvionDTO> getAvionByModelAndPrice(@Argument String model, @Argument float price) {
        return avionMapper.toDTOs(avionService.findByModelAndPrice(model, price));
    }

    // Mutation to save a new avion
    @MutationMapping
    public AvionDTO saveAvion(
            @Argument String model,
            @Argument String color,
            @Argument String matricul,
            @Argument float price) {
        AvionDTO avionDTO = new AvionDTO(model, color, matricul, price);
        return avionMapper.AviontoAvionDTO(avionService.save(avionMapper.AvionDTOtoAvion(avionDTO)));
    }

    // Mutation to delete an avion by matricul
    @MutationMapping
    public Boolean deleteAvion(@Argument String matricul) {
        return avionService.deleteByMatricul(matricul);
    }
}