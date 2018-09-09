package xyz.coolblog.chapter4.dao;

import org.apache.ibatis.annotations.Param;
import xyz.coolblog.chapter4.model.Article;
import xyz.coolblog.chapter4.model.Author;


/**
 * ArticleDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:20:51
 */
public interface ArticleDao {

    Article findOne(@Param("id") int id);

    Author findAuthor(@Param("article_author_id") int authorId);
}
