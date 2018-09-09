package xyz.coolblog.chapter7.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import xyz.coolblog.chapter7.model.Student;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-08-25 18:25:33
 */
public interface StudentDao {

    List<Student> findByPaging(@Param("id") Integer id, RowBounds rb);
}
