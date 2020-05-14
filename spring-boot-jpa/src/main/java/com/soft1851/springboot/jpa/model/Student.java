package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 16:41
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "student_name", nullable = false, length = 30)
    private String studentName;

    @Column(name = "age", nullable = false, length = 30)
    private Integer age;

    /**
     * 通过joinTable产生一个关联表
     * 关联表中有本表的id和另一个对应的实体类的id（course_id）
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList;
}
