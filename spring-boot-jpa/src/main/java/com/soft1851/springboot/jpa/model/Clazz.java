package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 16:39
 */
@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "clazz_name", nullable = false, length = 20)
    private String clazzName;

    /**
     * 启动后会在学生表里面生成一个clazz_id，关联
     * 懒汉式加载不得行，老师那边插到班级，班级就没办法继续往下查了
     * 所以要用饿汉式，FetchType.EAGER
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private List<Student> studentList;
}
