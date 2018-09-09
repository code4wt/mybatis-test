package xyz.coolblog.chapter1.model2;

import java.io.Serializable;
import java.util.Date;
import xyz.coolblog.constant.ArticleTypeEnum;

/**
 * Article
 *
 * @author Tian ZhongBo
 * @date 2018-06-25 14:11:14
 */
public class Article implements Serializable {

    private Integer id;

    private String title;

    private Author author;

    private String content;

    private ArticleTypeEnum type;

    private Date createTime;

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

    public ArticleTypeEnum getType() {
        return type;
    }

    public void setType(ArticleTypeEnum type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author=" + author +
            ", content='" + content + '\'' +
            ", type=" + type +
            ", createTime=" + createTime +
            '}';
    }
}
