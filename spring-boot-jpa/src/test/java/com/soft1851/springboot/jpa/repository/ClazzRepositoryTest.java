package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Course;
import com.soft1851.springboot.jpa.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClazzRepositoryTest {
    @Autowired
    private ClazzRepository clazzRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Test
    void findClazzById() {
        System.out.println(clazzRepository.findClazzById(1));
    }
    @Test
    void testManyToMany(){
        List<Student> students = studentRepository.findStudentByClazzId(1);
        students.forEach(student -> {
            System.out.println(student.getId() + "," + student.getStudentName() + "," + student.getAge());
            List<Course> courseList = student.getCourseList();
            courseList.forEach(course -> {
                System.out.println(student.getStudentName()+"同学选了"+course.getId()+ "," +course.getCourseName());
            });
        });
    }
    @Test
    void findStudentByCourse(){
        Course course = courseRepository.findCourseByCourseName("Java");
        System.out.println(course);
    }
}