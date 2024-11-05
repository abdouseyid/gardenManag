package edu.miu.cse;

import edu.miu.cse.model.Garden;
import edu.miu.cse.model.Plant;
import edu.miu.cse.service.GardenService;
import edu.miu.cse.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GardenManagApplication {
    private final PlantService plantService;
    private final GardenService gardenService;

    public static void main(String[] args) {
        SpringApplication.run(GardenManagApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Garden garden1 = new Garden();
            garden1.setName("Vegetable Patch");
            garden1.setSize(50.0);
//            System.out.println(garden1.toString());
            Garden garden2 = new Garden();
            garden2.setName("Herb Garden");
            garden2.setSize(20.0);

            gardenService.addNewGarden(garden1);
            gardenService.addNewGarden(garden2);

            Plant plant1 = new Plant();
            plant1.setName("Tomato");
            plant1.setType("Vegetable");
            plant1.setPlantDate(LocalDate.of(2024,03,10));
            plant1.setGarden(garden1);

            Plant plant2 = new Plant();
            plant2.setName("Carrot");
            plant2.setType("Vegetable");
            plant2.setPlantDate(LocalDate.of(2024,02,20));
            plant2.setGarden(garden1);

            Plant plant3 = new Plant();
            plant3.setName("Basil");
            plant3.setType("Herb");
            plant3.setPlantDate(LocalDate.of(2024,04,05));
            plant3.setGarden(garden2);

            plantService.addNewPlant(plant1);
            plantService.addNewPlant(plant2);
            plantService.addNewPlant(plant3);

            List<Garden> gardens = gardenService.getAllGardens();
            List<Plant> plants = plantService.getAllPlantsOrderByName();
            List<Plant> plants1 = plantService.getAllPlantsOrderByName();

            System.out.println("Display All Gardens");
            System.out.println("Gardens:");
            for (Garden garden : gardens) {
                System.out.println(garden);
            }

            System.out.println("Display All Plants(Sorted By Name)");
            System.out.println("Plants:");
            for (Plant plant : plants) {
                System.out.println(plant);
            }

            System.out.println("Display All Plants(Sorted By Plant Date)");
            System.out.println("Plants:");
            for (Plant plant : plants) {
                System.out.println(plant);
            }

        };
    }
}
