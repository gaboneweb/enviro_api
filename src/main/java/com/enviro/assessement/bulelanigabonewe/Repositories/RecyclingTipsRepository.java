package com.enviro.assessement.bulelanigabonewe.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips,Long> {

}
