package com.SpringJPADemo.SpringJPADemo.repository;

import com.SpringJPADemo.SpringJPADemo.entity.Course;
import com.SpringJPADemo.SpringJPADemo.entity.Student;
import com.SpringJPADemo.SpringJPADemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course = Course.builder()
                .courseTitle("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(courses);
        System.out.println(totalElements);
        System.out.println(totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("courseTitle").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();
        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Yadav")
                .emailId("abhi@gmail.com")
                .build();
        Course course = Course.builder()
                .courseTitle("AI")
                .credit(6)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }

}