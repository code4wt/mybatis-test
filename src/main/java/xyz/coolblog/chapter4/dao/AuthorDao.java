package xyz.coolblog.chapter4.dao;

import java.util.List;
import xyz.coolblog.chapter4.model.Author;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:53:53
 */
public interface AuthorDao {

    int insertMany(List<Author> authors);
}
