package com.example.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cybrilla.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}

