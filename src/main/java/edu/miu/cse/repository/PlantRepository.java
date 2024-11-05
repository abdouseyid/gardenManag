package edu.miu.cse.repository;

import edu.miu.cse.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Optional<Plant> findPlantByName(String name);
    @Query("SELECT p from Plant p ORDER BY p.plantDate asc")
    List<Plant> findAllPlants();
}
