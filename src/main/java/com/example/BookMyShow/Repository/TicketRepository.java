package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
