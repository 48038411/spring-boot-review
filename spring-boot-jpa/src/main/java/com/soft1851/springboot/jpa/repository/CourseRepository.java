package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    /**
     * 根据课程id查询课程
     * @param courseName
     * @return
     */
    Course findCourseByCourseName(String courseName);
}
