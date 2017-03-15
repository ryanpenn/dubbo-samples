package cn.ryanpenn.dubbo.samples.shop.service.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * AppConfiguration.
 */
@Configuration
@EnableTransactionManagement
@ImportResource(value = {"classpath:dubbo-context.xml"})
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"cn.ryanpenn.dubbo.samples.shop.service.user"})
public class AppConfiguration implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public SqlSessionFactory sessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:persist/mapper/*.xml"));

        sessionFactoryBean.setTypeAliasesPackage("cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity");
        sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor()});
        //sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));

        SqlSessionFactory sqlSessionFactory= sessionFactoryBean.getObject();
        // 下划线转驼峰
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
        return transactionManager;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.ryanpenn.dubbo.samples.shop.service.user.persist");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean
    public PageInterceptor pageInterceptor() {
        Properties properties = new Properties();
        properties.setProperty("pagehelper.dialect", environment.getProperty("pagehelper.dialect"));
        properties.setProperty("pagehelper.offsetAsPageNum", environment.getProperty("pagehelper.offsetAsPageNum"));
        properties.setProperty("pagehelper.rowBoundsWithCount", environment.getProperty("pagehelper.rowBoundsWithCount"));
        properties.setProperty("pagehelper.pageSizeZero", environment.getProperty("pagehelper.pageSizeZero"));
        properties.setProperty("pagehelper.reasonable", environment.getProperty("pagehelper.reasonable"));
        //properties.setProperty("pagehelper.params",environment.getProperty("pagehelper.params"));
        properties.setProperty("pagehelper.supportMethodsArguments", environment.getProperty("pagehelper.supportMethodsArguments"));
        properties.setProperty("pagehelper.returnPageInfo", environment.getProperty("pagehelper.returnPageInfo"));

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);

        return pageInterceptor;
    }
}
