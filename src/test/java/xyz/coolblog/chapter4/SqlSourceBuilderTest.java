package xyz.coolblog.chapter4;

import java.util.HashMap;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import xyz.coolblog.chapter4.model1.Author;

/**
 * SqlSourceBuilderTest
 *
 * @author Tian ZhongBo
 * @date 2018-08-09 20:40:08
 */
public class SqlSourceBuilderTest {

    @Test
    public void test() {
//        String sql = "SELECT * FROM Author WHERE name = #{name} AND age = #{age}";
        String sql = "SELECT * FROM Author WHERE age = #{age,javaType=int,jdbcType=NUMERIC}";
        SqlSourceBuilder sqlSourceBuilder = new SqlSourceBuilder(new Configuration());
        SqlSource sqlSource = sqlSourceBuilder.parse(sql, Author.class, new HashMap<>());
        BoundSql boundSql = sqlSource.getBoundSql(new Author());

        System.out.println(String.format("SQL: %s\n", boundSql.getSql()));
        System.out.println(String.format("ParameterMappings: %s", boundSql.getParameterMappings()));
    }
}
