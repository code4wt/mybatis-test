package xyz.coolblog.chapter4;

import java.io.IOException;
import java.util.Arrays;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.scripting.xmltags.TextSqlNode;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import xyz.coolblog.chapter4.model1.Article;

/**
 * AutoMappingTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-25 11:46:47
 */
public class SqlNodeTest {

    @Test
    public void testTextSqlNode() throws IOException {
        TextSqlNode tsn = new TextSqlNode("SELECT * FROM article WHERE author = '${article.author}'");
        Article article = new Article();
        article.setAuthor("tianxiaobo");
        ParamMap pm = new ParamMap<>();
        pm.put("article", article);
        DynamicContext dc = new DynamicContext(new Configuration(), pm);
        tsn.apply(dc);
        System.out.println(dc.getSql());

        article.setAuthor("tianxiaobo'; DELETE FROM article;#");
        dc = new DynamicContext(new Configuration(), pm);
        tsn.apply(dc);
        System.out.println(dc.getSql());
    }

    @Test
    public void testWhereSqlNode() throws IOException {
        String sqlFragment = "AND id = #{id}";
        MixedSqlNode msn = new MixedSqlNode(Arrays.asList(new StaticTextSqlNode(sqlFragment)));
        WhereSqlNode wsn = new WhereSqlNode(new Configuration(), msn);
        DynamicContext dc = new DynamicContext(new Configuration(), new ParamMap<>());
        wsn.apply(dc);
        System.out.println("解析前：" + sqlFragment);
        System.out.println("解析后：" + dc.getSql());
    }
}
