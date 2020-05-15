package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-15 15:36
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 查询月份日期与当天相等的数据
     * @return
     */
    @Query(value = "SELECT * FROM user WHERE MONTH(birthday) = MONTH(NOW()) AND DAY(birthday) = DAY(NOW())",nativeQuery = true)
    List<User> findUsersByBirthday();
}
