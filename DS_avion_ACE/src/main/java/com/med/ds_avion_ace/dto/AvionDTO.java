package com.med.ds_avion_ace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvionDTO {
    private String model;
    private String color;
    private String matricul;
    private double price;
}
