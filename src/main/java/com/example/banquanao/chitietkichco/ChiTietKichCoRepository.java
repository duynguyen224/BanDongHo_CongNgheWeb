package com.example.banquanao.chitietkichco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietKichCoRepository extends JpaRepository<ChiTietKichCo, Long> {
}
