package com.osho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osho.model.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {

}
