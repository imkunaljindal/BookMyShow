package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity, Integer> {
}
