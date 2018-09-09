package xyz.coolblog.chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter4.dao.AuthorDao;
import xyz.coolblog.chapter4.model.Author;


/**
 * OneToOneTest
 *
 * @author Tian ZhongBo
 * @date 2018-08-13 10:06:11
 */
public class InsertManyTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter4/mybatis-config2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testInsertMany() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Author> authors = new ArrayList<>();
            authors.add(new Author("tianxiaobo-1", 20, 0, "coolblog.xyz@outlook.com"));
            authors.add(new Author("tianxiaobo-2", 18, 0, "coolblog.xyz@outlook.com"));

            System.out.println("\nBefore Insert: ");
            authors.forEach(author -> System.out.println("  " + author));
            System.out.println();

            AuthorDao authorDao = session.getMapper(AuthorDao.class);
            authorDao.insertMany(authors);
            session.commit();

            System.out.println("\nAfter Insert: ");
            authors.forEach(author -> System.out.println("  " + author));
        } finally {
            session.close();
        }
    }
}
