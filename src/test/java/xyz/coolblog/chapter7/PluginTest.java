package xyz.coolblog.chapter7;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter7.dao.StudentDao;

/**
 * MyBatisTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:24:55
 */
public class PluginTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter7/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testPlugin() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            studentDao.findByPaging(1, new RowBounds(20, 10));
        } finally {
            session.close();
        }
    }
}
