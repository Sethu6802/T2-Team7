package com.example.volunteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.volunteer.model.Helper;

@Repository
public interface HelperRepository extends JpaRepository<Helper, Long> {

}


