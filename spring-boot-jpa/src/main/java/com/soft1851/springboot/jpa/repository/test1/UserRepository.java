package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 21:33
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
