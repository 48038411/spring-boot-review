package com.soft1851.springboot.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-15 19:57
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cron {
    @GeneratedValue
    @Id
    private Integer cronId;

    @Column(name = "column_name",nullable = false,length = 10)
    private String cronName;

    @Column(name = "cron",nullable = false,length = 50)
    private String cron;
}
