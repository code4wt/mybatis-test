package xyz.coolblog.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter1.dao2.AuthorDao;
import xyz.coolblog.chapter1.dao2.ArticleDao;
import xyz.coolblog.chapter1.model2.Author;
import xyz.coolblog.chapter1.model2.Article;

/**
 * MyBatisTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:24:55
 */
public class MyBatisTest2 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter1/mybatis-config2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testOne2One() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(1);

            Author author = article.getAuthor();
            article.setAuthor(null);

            System.out.println("\nauthor info:");
            System.out.println(author);
            System.out.println("\narticles info:");
            System.out.println(article);
        } finally {
            session.close();
        }
    }

    @Test
    public void testOne2Many() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            AuthorDao authorDao = session.getMapper(AuthorDao.class);
            Author author = authorDao.findOne(1);

            List<Article> arts = author.getArticles();
            List<Article> articles = Arrays.asList(arts.toArray(new Article[arts.size()]));
            arts.clear();

            System.out.println("\nauthor info:");
            System.out.println(author);
            System.out.println("\narticles info:");
            articles.forEach(System.out::println);
        } finally {
            session.close();
        }
    }
}
