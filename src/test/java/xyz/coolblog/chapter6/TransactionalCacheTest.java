package xyz.coolblog.chapter6;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.coolblog.chapter6.dao.StudentDao;
import xyz.coolblog.chapter6.model.Student;

/**
 * AutoMappingTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-25 11:46:47
 */
public class TransactionalCacheTest {

    private SqlSessionFactory sqlSessionFactory;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Before
    public void prepare() throws IOException {
        String resource = "chapter6/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testTransactional() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> fa = es.submit(this::transactionalA);
        Future<String> fb = es.submit(this::transactionalB);

        countDownLatch.countDown();
        es.awaitTermination(6, TimeUnit.SECONDS);

        System.out.println(fa.get());
        System.out.println("\n -------- 分割线 ------- \n");
        System.out.println(fb.get());

        System.out.println();
        System.out.println();
        System.out.println();
    }

    private String transactionalA() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        countDownLatch.await();

        StringBuilder sb = new StringBuilder();
        sb.append("时刻1：开启事务 A\n");
        sb.append("时刻2：查询记录 A\n");

        Student s1 = studentDao.findOne(1);
        sb.append(s1).append("\n");

        sb.append("时刻3：更新记录 A\n");
        studentDao.update(1, "tianxiaobo");
        sb.append("时刻4：查询记录 A'\n");
        Student s2 = studentDao.findOne(1);
        sb.append(s2).append("\n");

        Thread.sleep(1000);

        sb.append("时刻5：提交事务 A");
        sqlSession.commit();

        return sb.toString();
    }

    private String transactionalB() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        countDownLatch.await();

        StringBuilder sb = new StringBuilder();
        sb.append("时刻1：开启事务 B\n");
        sb.append("时刻2：查询数据 A\n");
        Student s1 = studentDao.findOne(1);
        sb.append(s1).append("\n");

        sb.append("时刻3：---------\n");
        sb.append("时刻4：查询数据 A\n");
        Student s2 = studentDao.findOne(1);
        sb.append(s2).append("\n");

        Thread.sleep(3000);

        sb.append("时刻5：---------\n");
        sb.append("时刻6：查询数据 A'\n");
        Student s3 = studentDao.findOne(1);
        sb.append(s3).append("\n");

        sb.append("时刻7：提交事务 B");
        sqlSession.commit();
        return sb.toString();
    }
}
