package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Guorc
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    /**
     * 根据老师姓名查询信息
     * @param teacherName
     * @return
     */
    Teacher findTeacherByTeacherName(String teacherName);
}
