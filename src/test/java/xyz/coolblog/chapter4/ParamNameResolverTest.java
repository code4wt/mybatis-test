package xyz.coolblog.chapter4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import xyz.coolblog.chapter4.model1.Article;

/**
 * ParamNameResolverTest
 *
 * @author Tian ZhongBo
 * @date 2018-08-01 20:39:13
 */
public class ParamNameResolverTest {

    @Test
    public void test() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Configuration config = new Configuration();
        config.setUseActualParamName(false);
        Method method = ArticleMapper.class.getMethod("select", Integer.class, String.class, RowBounds.class, Article.class);

        ParamNameResolver resolver = new ParamNameResolver(config, method);
        Field field = resolver.getClass().getDeclaredField("names");
        field.setAccessible(true);
        Object names = field.get(resolver);

        System.out.println("names: " + names);
    }

    @Test
    public void testGetNamedParams() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Configuration config = new Configuration();
        config.setUseActualParamName(false);
        Method method = ArticleMapper.class.getMethod("select", Integer.class, String.class, RowBounds.class, Integer.class);

        ParamNameResolver resolver = new ParamNameResolver(config, method);

        System.out.println("names: " + resolver.getNamedParams(new Object[]{1, "coolblog.xyz", new RowBounds(), 20}));
    }

    class ArticleMapper {

        public void select(@Param("id") Integer id, @Param("author") String author, RowBounds rb, Article article) {}

        public void select(@Param("id") Integer id, @Param("author") String author, RowBounds rb, Integer age) {}
    }
}
