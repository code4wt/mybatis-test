package xyz.coolblog.chapter4.model1;

import java.io.Serializable;
import java.util.List;
import xyz.coolblog.constant.SexEnum;

/**
 * Author
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:54:45
 */
public class Author implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private SexEnum sex;

    private String email;

    private List<Article> articles;

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Author{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", sex=" + sex +
            ", email='" + email + '\'' +
            ", articles=" + articles +
            '}';
    }
}
