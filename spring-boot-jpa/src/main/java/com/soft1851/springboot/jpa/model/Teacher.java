package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 16:44
 */
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 30)
    private String teacherName;
    /**
     * name=“clazz_id”，是自己起的名字,外键直接关联到另一个表的id
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id", referencedColumnName = "id")
    private Clazz clazz;
}
