package com.example.messageSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.messageSystem.model.SosMessage;

@Repository
public interface SosMessageRepository extends JpaRepository<SosMessage, Long> {
}