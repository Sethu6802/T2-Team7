package com.a.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a.model.Model;

@Repository
public interface RepoA extends JpaRepository<Model, Integer>{

}