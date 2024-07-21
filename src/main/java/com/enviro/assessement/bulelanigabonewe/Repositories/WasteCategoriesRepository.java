package com.enviro.assessement.bulelanigabonewe.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;

@Repository
public interface WasteCategoriesRepository extends JpaRepository<WasteCategories,Long> {
    
    @Query("SELECT g FROM WasteCategories g")
    public List<WasteCategories> getCategories();
}
