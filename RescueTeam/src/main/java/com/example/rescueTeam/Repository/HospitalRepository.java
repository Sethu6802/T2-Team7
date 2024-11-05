package com.example.rescueTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rescueTeam.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
