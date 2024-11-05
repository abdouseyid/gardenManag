package edu.miu.cse.service.impl;

import edu.miu.cse.model.Plant;
import edu.miu.cse.repository.PlantRepository;
import edu.miu.cse.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImp implements PlantService {
    private final PlantRepository plantRepository;

    @Override
    public Optional<Plant> addNewPlant(Plant plant) {
        return Optional.of(plantRepository.save(plant));
    }

    @Override
    public Optional<Plant> updatePlant(String name, Plant plant) {
        Optional<Plant> foundPlant = plantRepository.findPlantByName(name);
        foundPlant.ifPresent(plant1 -> {
            plant1.setName(plant.getName());
            plant1.setType(plant.getType());
            plant1.setPlantDate(plant.getPlantDate());
            plant1.setGarden(plant.getGarden());
        });
        return foundPlant;
    }

    @Override
    public void deletePlant(String name) {
        plantRepository.findPlantByName(name).ifPresent(plantRepository::delete);
    }

    @Override
    public List<Plant> getAllPlantsOrderByName() {
        return plantRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Plant> getAllPlantsOrderByPlantDate() {
        return plantRepository.findAllPlants();
    }
}
