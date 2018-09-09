package xyz.coolblog.chapter3;

import java.io.InputStream;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

/**
 * ResultMapTest
 *
 * @author Tian ZhongBo
 * @date 2018-07-26 22:04:47
 */
public class ResultMapTest {

    @Test
    public void printResultMapInfo() throws Exception {
        Configuration configuration = new Configuration();
        String resource = "chapter3/mapper/ArticleMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
        builder.parse();

        ResultMap resultMap = configuration.getResultMap("articleResult");

        System.out.println("\n-------------------+✨ mappedColumns ✨+--------------------");
        System.out.println(resultMap.getMappedColumns());

        System.out.println("\n------------------+✨ mappedProperties ✨+------------------");
        System.out.println(resultMap.getMappedProperties());

        System.out.println("\n------------------+✨ idResultMappings ✨+------------------");
        resultMap.getIdResultMappings().forEach(rm -> System.out.println(simplify(rm)));

        System.out.println("\n---------------+✨ propertyResultMappings ✨+---------------");
        resultMap.getPropertyResultMappings().forEach(rm -> System.out.println(simplify(rm)));

        System.out.println("\n-------------+✨ constructorResultMappings ✨+--------------");
        resultMap.getConstructorResultMappings().forEach(rm -> System.out.println(simplify(rm)));

        System.out.println("\n------------------+✨ resultMappings ✨+--------------------");
        resultMap.getResultMappings().forEach(rm -> System.out.println(simplify(rm)));

        System.out.println();
        inputStream.close();
    }

    private String simplify(ResultMapping resultMapping) {
        return String.format("ResultMapping{column='%s', property='%s', flags=%s, ...}",
            resultMapping.getColumn(), resultMapping.getProperty(), resultMapping.getFlags());
    }
}
