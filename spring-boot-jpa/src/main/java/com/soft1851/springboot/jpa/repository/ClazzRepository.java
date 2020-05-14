package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Guorc
 */
public interface ClazzRepository extends JpaRepository<Clazz,Integer> {
    /**
     * 根据id查询班级（根据方法名自动生成SQL）
     * @param id
     * @return
     */
    Clazz findClazzById(Integer id);
}
