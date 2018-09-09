package xyz.coolblog.chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import xyz.coolblog.chapter1.model.Article;

/**
 * JdbcTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-12 00:09:10
 */
public class JdbcTest {

    @Test
    public void testJdbc() {
        String url = "jdbc:mysql://localhost:3306/myblog?user=root&password=1234&useUnicode=true&characterEncoding=UTF8&useSSL=false";

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url);

            String author = "coolblog.xyz";
            String date = "2018.06.10";
            String sql = "SELECT id, title, author, content, create_time FROM blog_article WHERE author = '" + author + "' AND create_time > '" + date + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Article> articles = new ArrayList<>(rs.getRow());
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setAuthor(rs.getString("author"));
                article.setContent(rs.getString("content"));
                article.setCreateTime(rs.getDate("create_time"));
                articles.add(article);
            }
            System.out.println("Query SQL ==> " + sql);
            System.out.println("Query Result: ");
            articles.forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
