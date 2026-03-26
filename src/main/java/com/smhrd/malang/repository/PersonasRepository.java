package com.smhrd.malang.repository;

import com.smhrd.malang.entity.Personas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonasRepository extends JpaRepository<Personas, Integer> {
    List<Personas> findByUserId(Integer userId);
}
