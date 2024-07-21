package com.enviro.assessement.bulelanigabonewe.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;

import jakarta.transaction.Transactional;


@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips,Long> {

    @Query("SELECT g FROM RecyclingTips g where g.category.categoryId = ?1")
    public List<RecyclingTips> findRecyclingTipsByCategoryId(Long categoryId);

    @Modifying
    @Transactional 
    @Query("DELETE FROM RecyclingTips g where g.category.categoryId = ?1")
    public void deleteRecyclingTipsByCategoryId(Long categoryId);
}
