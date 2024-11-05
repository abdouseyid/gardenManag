package edu.miu.cse.service;

import edu.miu.cse.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> addNewGarden(Garden garden);
    Optional<Garden> updateGarden(String name, Garden garden);
    void deleteGarden(String name);
    List<Garden> getAllGardens();
}
