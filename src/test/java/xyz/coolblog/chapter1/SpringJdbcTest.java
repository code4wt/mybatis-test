package xyz.coolblog.chapter1;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.coolblog.chapter1.model.Article;

/**
 * SpringJdbcTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-12 16:43:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:chapter1/application.xml")
public class SpringJdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testSpringJdbc() {
        String author = "coolblog.xyz";
        String date = "2018.06.10";
        String sql = "SELECT id, title, author, content, create_time"
             + " FROM blog_article"
             + " WHERE author = '" + author + "' AND create_time > '" + date + "'";
        List<Article> articles = jdbcTemplate.query(sql, (rs, rowNum) -> {
                    Article article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setAuthor(rs.getString("author"));
                    article.setContent(rs.getString("content"));
                    article.setCreateTime(rs.getDate("create_time"));
                    return article;
            });

        System.out.println("Query SQL ==> " + sql);
        System.out.println("Spring JDBC Query Result: ");
        articles.forEach(System.out::println);
    }
}
