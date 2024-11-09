package com.example.messageSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.messageSystem.model.SosMessage;

@Repository
public interface sosRepo extends JpaRepository<SosMessage,Long>{

}
