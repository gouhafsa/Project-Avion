package com.med.ds_avion_ace;

import com.med.ds_avion_ace.Entity.Avion;
import com.med.ds_avion_ace.Repository.AvionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DsAvionAceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsAvionAceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AvionRepository avionRepository) {
        return args -> {
            avionRepository.save(new Avion(null, "Boeing 737", "White", "MAT123", 80000000.0));
            avionRepository.save(new Avion(null, "Airbus A320", "Blue", "MAT124", 90000000.0));
            avionRepository.save(new Avion(null, "Cessna 172", "Red", "MAT125", 300000.0));
            avionRepository.save(new Avion(null, "Gulfstream G650", "Black", "MAT126", 65000000.0));

            avionRepository.findAll().forEach(System.out::println);
        };
    }


}
