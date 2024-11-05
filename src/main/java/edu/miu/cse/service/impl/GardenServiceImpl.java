package edu.miu.cse.service.impl;

import edu.miu.cse.model.Garden;
import edu.miu.cse.repository.GardenRepository;
import edu.miu.cse.service.GardenService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {
    private final GardenRepository gardenRepository;

    @Override
    public Optional<Garden> addNewGarden(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }

    @Override
    public Optional<Garden> updateGarden(String name, Garden garden) {
        Optional<Garden> foundGarden = gardenRepository.findGardenByName(name);
        foundGarden.ifPresent(garden1 -> {
            garden1.setName(garden.getName());
            garden1.setSize(garden.getSize());
        });
        return foundGarden;
    }

    @Override
    public void deleteGarden(String name) {
        gardenRepository.findGardenByName(name).ifPresent(garden -> {
            gardenRepository.delete(garden);
        });
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepository.findAllData();
    }
}
