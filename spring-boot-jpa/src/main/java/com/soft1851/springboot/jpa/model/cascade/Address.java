package com.soft1851.springboot.jpa.model.cascade;

import lombok.Data;

import javax.persistence.*;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-12 19:27
 */
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "phone", nullable = true, length = 11)
    private String phone;

    @Column(name = "zipcode", nullable = true, length = 6)
    private String zipcode;

    @Column(name = "address", nullable = true, length = 100)
    private String address;

    /**
     * 如果不需要根据Address级联查询 People，可以注释掉
     */
    @OneToOne(mappedBy = "address", cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, optional = false)
    private People people;
}