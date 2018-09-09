package xyz.coolblog.chapter1.dao2;

import org.apache.ibatis.annotations.Param;
import xyz.coolblog.chapter1.model2.Author;

/**
 * AuthorDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:53:53
 */
public interface AuthorDao {

    Author findOne(@Param("id") int id);
}
