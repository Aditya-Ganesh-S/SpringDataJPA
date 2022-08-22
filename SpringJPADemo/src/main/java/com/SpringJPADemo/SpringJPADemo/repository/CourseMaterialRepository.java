package com.SpringJPADemo.SpringJPADemo.repository;

import com.SpringJPADemo.SpringJPADemo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}