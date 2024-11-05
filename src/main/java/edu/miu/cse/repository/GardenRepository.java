package edu.miu.cse.repository;

import edu.miu.cse.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GardenRepository extends JpaRepository<Garden, Integer> {
    Optional<Garden> findGardenByName(String name);
    @Query("select g from Garden g")
    List<Garden> findAllData();
}
