package xyz.coolblog.constant;

/**
 * ArticleCategoryEnum
 *
 * @author Tian ZhongBo
 * @date 2018-07-15 15:21:56
 */
public enum ArticleCategoryEnum {

    JAVA(1),
    DUBBO(2),
    SPRING(3),
    MYBATIS(4);

    private int code;

    ArticleCategoryEnum(int code) {
        this.code = code;
    }
}
