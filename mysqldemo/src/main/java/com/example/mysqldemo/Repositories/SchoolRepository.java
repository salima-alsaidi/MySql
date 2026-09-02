package com.example.mysqldemo.Repositories;

import com.example.mysqldemo.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

  @Query("SELECT s FROM School s WHERE s.isActive=true")
  List<School>getAllSchool();

    @Query("SELECT s FROM School s WHERE s.isActive=true AND s.id= :id")
    School getById(@Param("id") Long id);
}

