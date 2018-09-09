package xyz.coolblog.chapter2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.junit.Test;
import xyz.coolblog.mybatis.ArticleTypeHandler;

/**
 * MetaClassTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-18 14:07:01
 */
public class MetaClassTest {

    @Test
    public void testParameterizedType() {
        Method[] ms = ArticleTypeHandler.class.getMethods();
        Arrays.asList(ms).forEach(m -> {
            System.out.println("-------" + m.getName() + "--------");
            Type[] pts = m.getGenericParameterTypes();
            Arrays.stream(pts).forEach(t -> {
                System.out.println(t.getTypeName());
            });
        });
    }

    @Test
    public void testHasSetter() {
        MetaClass authorMeta = MetaClass.forClass(Author.class, new DefaultReflectorFactory());

        System.out.println("\n------------☆ Author ☆------------");
        System.out.println("id -> " + authorMeta.hasSetter("id"));
        System.out.println("name -> " + authorMeta.hasSetter("name"));
        System.out.println("age -> " + authorMeta.hasSetter("age"));
        System.out.println("articles -> " + authorMeta.hasSetter("articles"));
        System.out.println("articles[] -> " + authorMeta.hasSetter("articles[]"));
        System.out.println("title -> " + authorMeta.hasSetter("title"));

        MetaClass articleMeta = MetaClass.forClass(Article.class, new DefaultReflectorFactory());
        System.out.println("\n------------☆ Article ☆------------");
        System.out.println("id -> " + articleMeta.hasSetter("id"));
        System.out.println("title -> " + articleMeta.hasSetter("title"));
        System.out.println("content -> " + articleMeta.hasSetter("content"));
        System.out.println("author.id -> " + articleMeta.hasSetter("author.id"));
        System.out.println("author.name -> " + articleMeta.hasSetter("author.name"));
        System.out.println();
    }

    private class Author {
        private Integer id;
        private String name;
        private Integer age;
        private Article[] articles;

        // 省略 getter/setter 和 toString

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Article[] getArticles() {
            return articles;
        }

        public void setArticles(Article[] articles) {
            this.articles = articles;
        }
    }

    private class Article {
        private Integer id;
        private String title;
        private Author author;
        private String content;

        // 省略 getter/setter 和 toString

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}


