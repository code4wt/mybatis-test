package xyz.coolblog.chapter1.dao2;

import org.apache.ibatis.annotations.Param;
import xyz.coolblog.chapter1.model2.Article;

/**
 * ArticleDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:20:51
 */
public interface ArticleDao {

    Article findOne(@Param("id") int id);
}
