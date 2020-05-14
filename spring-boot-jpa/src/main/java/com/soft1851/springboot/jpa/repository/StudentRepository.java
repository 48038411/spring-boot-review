package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    /**
     * 根据学生姓名查询学生信息
     * @param studentName
     * @return
     */
    Student findStudentByStudentName(String studentName);

    /**
     * 根据班级id查询学生信息，原生SQL
     * @param clazzId
     * @return
     */
    @Query(value = "select id,student_name,age from student where clazz_id = ?1",nativeQuery = true)
    List<Student> findStudentByClazzId(int clazzId);
}
