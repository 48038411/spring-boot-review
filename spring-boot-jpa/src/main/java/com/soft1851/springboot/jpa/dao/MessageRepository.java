package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-12 19:35
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {
    /**
     * 解析方法名创建查询：根据摘要查询
     *
     * @param msgSummary
     * @return
     */
    List<Message> findByMsgSummary(String msgSummary);

    /**
     * 解析方法名创建查询:根据内容或者摘要查询
     * @param msgText
     * @param msgSummary
     * @return
     */
    List<Message> findByMsgTextOrMsgSummary(String msgText, String msgSummary);

    /**
     * 解析方法名创建查询
     *
     * @param text：根据内容模糊查询
     * @return
     */
    List<Message> findByMsgTextLike(String text);

    /**
     * 解析方法名创建查询：查询比指定maxId小的消息集合
     *
     * @param maxId
     * @return
     */
    List<Message> findDistinctByMsgIdLessThan(int maxId);

    /**
     * JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param msgId
     * @return
     */
    @Query("SELECT msgId, msgText, msgSummary FROM Message WHERE msgId = ?1")
    Message findById(int msgId);

    /**
     * 修改
     *
     * @param msgText
     * @param msgId
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE message SET msg_text = ?1 WHERE msg_id < ?2", nativeQuery = true)
    int updateName(String msgText, int msgId);

    /**
     * 分页查询
     *
     * @param msgSummary
     * @param pageable
     * @return
     */
    @Query("SELECT m FROM Message m WHERE m.msgSummary=?1")
    Page<Message> findByName(String msgSummary, Pageable pageable);

    /**
     * 插入
     *
     * @param msgText
     * @param msgSummary
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "INSERT INTO message(msg_text, msg_summary) VALUES (:msgText, :msgSummary)", nativeQuery = true)
    Integer insertMessage(@Param("msgText") String msgText, @Param("msgSummary") String msgSummary);
}
