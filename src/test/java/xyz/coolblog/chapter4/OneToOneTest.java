package xyz.coolblog.chapter4;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter4.dao.ArticleDao;
import xyz.coolblog.chapter4.model.Article;
import xyz.coolblog.chapter4.model.Author;

/**
 * OneToOneTest
 *
 * @author Tian ZhongBo
 * @date 2018-08-13 10:06:11
 */
public class OneToOneTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter4/mybatis-config.xml";
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

            System.out.println("\narticles info:");
            System.out.println(article);

            System.out.println("\nauthor info:");
            System.out.println(author);
        } finally {
            session.close();
        }
    }

    @Test
    public void testOne2One2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(1);

            System.out.println("\narticles info:");
            System.out.println(article);

            System.out.println("\n延迟加载 author 字段：");

            Author author = article.getAuthor();
            System.out.println("\narticles info:");
            System.out.println(article);
            System.out.println("\nauthor info:");
            System.out.println(author);
        } finally {
            session.close();
        }
    }
}
