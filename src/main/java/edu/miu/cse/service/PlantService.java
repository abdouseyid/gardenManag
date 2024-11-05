package edu.miu.cse.service;

import edu.miu.cse.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant> addNewPlant(Plant plant);
    Optional<Plant> updatePlant(String name, Plant plant);
    void deletePlant(String name);
    List<Plant> getAllPlantsOrderByName();
    List<Plant> getAllPlantsOrderByPlantDate();
}
