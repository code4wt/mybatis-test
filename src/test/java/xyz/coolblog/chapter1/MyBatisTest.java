package xyz.coolblog.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter1.dao.ArticleDao;
import xyz.coolblog.chapter1.model.Article;

/**
 * MyBatisTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:24:55
 */
public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter1/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            List<Article> articles = articleDao.
                findByAuthorAndCreateTime("coolblog.xyz", "2018-06-10");

        } finally {
            session.commit();
            session.close();
        }
    }
}
