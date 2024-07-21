package com.enviro.assessement.bulelanigabonewe.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;

@Repository 
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long>{

    @Query("SELECT g FROM DisposalGuidelines g where g.category.categoryId = ?1")
    public List<DisposalGuidelines> findGuidelinesByCategoryId(Long categoryId);

}
