package com.SpringJPADemo.SpringJPADemo.repository;

import com.SpringJPADemo.SpringJPADemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
}
