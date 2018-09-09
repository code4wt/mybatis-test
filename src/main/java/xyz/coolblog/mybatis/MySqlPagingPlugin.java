package xyz.coolblog.mybatis;

import java.lang.reflect.Field;
import java.util.Properties;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * MySqlPagingPlugin
 *
 * @author Tian ZhongBo
 * @date 2018-08-25 17:37:41
 */
@Intercepts({
    @Signature(
        type = Executor.class,
        method = "query",
        args ={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
    )
})
public class MySqlPagingPlugin implements Interceptor {

    private static final Integer MAPPED_STATEMENT_INDEX = 0;
    private static final Integer PARAMETER_INDEX = 1;
    private static final Integer ROW_BOUNDS_INDEX = 2;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        RowBounds rb = (RowBounds) args[ROW_BOUNDS_INDEX];
        if (rb == RowBounds.DEFAULT) {
            return invocation.proceed();
        }
        args[ROW_BOUNDS_INDEX] = RowBounds.DEFAULT;

        MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
        BoundSql boundSql = ms.getBoundSql(args[PARAMETER_INDEX]);

        System.out.println();
        String sql = boundSql.getSql();
        String limit = String.format("LIMIT %d,%d", rb.getOffset(), rb.getLimit());
        sql = sql + " " + limit;

        SqlSource sqlSource = new StaticSqlSource(ms.getConfiguration(), sql, boundSql.getParameterMappings());

        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(ms, sqlSource);

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
