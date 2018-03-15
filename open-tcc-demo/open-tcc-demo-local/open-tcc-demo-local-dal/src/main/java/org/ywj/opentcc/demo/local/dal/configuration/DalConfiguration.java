package org.ywj.opentcc.demo.local.dal.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-09
 */
@Configuration
@ComponentScan("org.ywj.opentcc.demo.local.dal")
@EnableTransactionManagement
@PropertySource(value = "classpath:demo-db.properties",ignoreResourceNotFound = true)
public class DalConfiguration {

    @Value("${tcc.dbone.url}")
    private String dbOneUrl;

    @Value("${tcc.dbone.user}")
    private String dbOneUser;

    @Value("${tcc.dbone.password}")
    private String dbOnePassword;

//    @Value("${tcc.dbtwo.url}")
//    private String dbTwoUrl;
//
//    @Value("${tcc.dbtwo.user}")
//    private String dbTwoUser;
//
//    @Value("${tcc.dbtwo.password}")
//    private String dbTwoPassword;

//    @Autowired
//    private Environment env;

    @Bean(name = "demoDataSourceOne",initMethod = "init", destroyMethod = "close")
    public DruidDataSource demoDataSourceOne() {
        String path = DalConfiguration.class.getResource("/").toString();
        System.out.println("path = " + path);
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("tcc.dbone.url"));
//        dataSource.setUsername(env.getProperty("tcc.dbone.user"));
//        dataSource.setPassword(env.getProperty("tcc.dbone.password"));
        dataSource.setUrl(dbOneUrl);
        dataSource.setUsername(dbOneUser);
        dataSource.setPassword(dbOnePassword);
        //连接池大小
        dataSource.setInitialSize(5);
        //最大连接池数量
        dataSource.setMaxActive(20);
        //最小连接池数量
        dataSource.setMinIdle(5);
        //获取连接最大等待时间
        dataSource.setMaxWait(1000);
        //配置间隔多久进行一次检测,检测需要关闭的空闲连接
        dataSource.setTimeBetweenConnectErrorMillis(6000);
        //配置一个连接在池中的最小生存时间
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        dataSource.setPoolPreparedStatements(false);

        return dataSource;
    }

    @Bean(name = "sqlSessionFactoryBeanOne")
    public SqlSessionFactory sqlSessionFactoryBeanOne() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(demoDataSourceOne());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:META-INF/mappers/dbone/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ywj.opentcc.demo.local.dal.entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManagerOne")
    public PlatformTransactionManager transactionManagerOne() {
        return new DataSourceTransactionManager(demoDataSourceOne());
    }

    @Bean(name = "transactionTemplateOne")
    public TransactionTemplate transactionTemplateOne() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManagerOne());
        return transactionTemplate;
    }

//    @Bean(initMethod = "init", destroyMethod = "close", name = "demoDataSourceTwo")
//    public DruidDataSource demoDataSourceTwo() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("tcc.dbtwo.url"));
//        dataSource.setUsername(env.getProperty("tcc.dbtwo.user"));
//        dataSource.setPassword(env.getProperty("tcc.dbtwo.password"));
//        //连接池大小
//        dataSource.setInitialSize(5);
//        //最大连接池数量
//        dataSource.setMaxActive(20);
//        //最小连接池数量
//        dataSource.setMinIdle(5);
//        //获取连接最大等待时间
//        dataSource.setMaxWait(1000);
//        //配置间隔多久进行一次检测,检测需要关闭的空闲连接
//        dataSource.setTimeBetweenConnectErrorMillis(6000);
//        //配置一个连接在池中的最小生存时间
//        dataSource.setMinEvictableIdleTimeMillis(300000);
//        dataSource.setValidationQuery("SELECT 'x'");
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTestOnBorrow(false);
//        dataSource.setTestOnReturn(false);
//
//        dataSource.setPoolPreparedStatements(false);
//
//        return dataSource;
//    }

//    @Bean(name = "sqlSessionFactoryBeanTwo")
//    public SqlSessionFactory sqlSessionFactoryBeanTwo() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(demoDataSourceTwo());
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:META-INF/mappers/dbtwo/**/*.xml"));
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.ywj.opentcc.demo.local.dal.entity");
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean(name = "transactionManagerTwo")
//    public PlatformTransactionManager transactionManagerTwo() {
//        return new DataSourceTransactionManager(demoDataSourceTwo());
//    }
//
//    @Bean(name = "transactionTemplateTwo")
//    public TransactionTemplate transactionTemplateTwo() {
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        transactionTemplate.setTransactionManager(transactionManagerTwo());
//        return transactionTemplate;
//    }

    @Bean(name = "mapperScannerConfigurerOne")
    public MapperScannerConfigurer mapperScannerConfigurerOne() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.ywj.opentcc.demo.local.dal.mapper.dbone.auto");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBeanOne");
        return mapperScannerConfigurer;
    }

//    @Bean(name = "mapperScannerConfigurerTwo")
//    public MapperScannerConfigurer mapperScannerConfigurerTwo() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("org.ywj.opentcc.demo.local.dal.mapper.dbtwo.auto");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBeanTwo");
//        return mapperScannerConfigurer;
//    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
