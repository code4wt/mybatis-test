package xyz.coolblog.chapter6.dao;

import org.apache.ibatis.annotations.Param;
import xyz.coolblog.chapter6.model.Student;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:53:53
 */
public interface StudentDao {

    Student findOne(@Param("id") Integer id);

    int update(@Param("id") Integer id, @Param("name") String name);
}
