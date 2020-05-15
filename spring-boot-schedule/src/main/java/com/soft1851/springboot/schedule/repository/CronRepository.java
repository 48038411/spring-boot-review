package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Guorc
 */
public interface CronRepository extends JpaRepository<Cron,Integer> {
    /**
     * 根据cronId查询
     * @param cronId
     * @return
     */
    Cron findCronByCronIdEquals(int cronId);
}
