package com.example.restaurant.repository;

import com.example.restaurant.model.Administrator;
import com.example.restaurant.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryInterface extends JpaRepository<Administrator, Long> {
}
