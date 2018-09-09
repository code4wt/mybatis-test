package xyz.coolblog.mybatis;

import java.util.List;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggableObjectFactory
 *
 * @author Tian ZhongBo
 * @date 2018-07-06 10:22:26
 */
public class LoggableObjectFactory extends DefaultObjectFactory {

    private Logger logger = LoggerFactory.getLogger(LoggableObjectFactory.class);

    @Override
    public <T> T create(Class<T> type) {
//        System.out.println("using default constructor create " + type);
//        logger.info("using default constructor create {}", type);
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
//        System.out.println("using constructor create " + type + ", constructorArgs = " + constructorArgs);
//        logger.info("using constructor whith args {} create {}", constructorArgs, type);
        return super.create(type, constructorArgTypes, constructorArgs);
    }
}
