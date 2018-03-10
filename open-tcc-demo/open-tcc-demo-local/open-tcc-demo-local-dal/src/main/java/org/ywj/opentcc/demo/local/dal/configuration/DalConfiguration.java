package org.ywj.opentcc.demo.local.dal.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource(value = "classpath:demo-db.properties", ignoreResourceNotFound = true)
public class DalConfiguration {

    @Value("${tcc_demo_db1_url}")
    private String db1Url;

    @Value("${tcc_demo_db1_user}")
    private String db1User;

    @Value("${tcc_demo_db1_password}")
    private String db1Password;

    @Value("${tcc_demo_db2_url}")
    private String db2Url;

    @Value("${tcc_demo_db2_user}")
    private String db2User;

    @Value("${tcc_demo_db2_password}")
    private String db2Password;

    @Bean(initMethod = "init", destroyMethod = "close", name = "demoDataSource1")
    public DruidDataSource demoDataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(db1Url);
        dataSource.setUsername(db1User);
        dataSource.setPassword(db1Password);
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

    @Bean(name = "sqlSessionFactoryBean1")
    public SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(demoDataSource1());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:META-INF/mappers/dbone/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ywj.opentcc.demo.local.dal.entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager1")
    public PlatformTransactionManager transactionManager1() {
        return new DataSourceTransactionManager(demoDataSource1());
    }

    @Bean(name = "transactionTemplate1")
    public TransactionTemplate transactionTemplate1() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager1());
        return transactionTemplate;
    }

    @Bean(initMethod = "init", destroyMethod = "close", name = "demoDataSource2")
    public DruidDataSource demoDataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(db2Url);
        dataSource.setUsername(db2User);
        dataSource.setPassword(db2Password);
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

    @Bean(name = "sqlSessionFactoryBean2")
    public SqlSessionFactory sqlSessionFactoryBean2() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(demoDataSource2());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:META-INF/mappers/dbtwo/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ywj.opentcc.demo.local.dal.entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager2() {
        return new DataSourceTransactionManager(demoDataSource2());
    }

    @Bean(name = "transactionTemplate2")
    public TransactionTemplate transactionTemplate2() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager2());
        return transactionTemplate;
    }

    @Bean(name = "mapperScannerConfigurer1")
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.ywj.opentcc.demo.local.dal.mapper.dbone.auto");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean1");
        return mapperScannerConfigurer;
    }

    @Bean(name = "mapperScannerConfigurer2")
    public MapperScannerConfigurer mapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.ywj.opentcc.demo.local.dal.mapper.dbtwo.auto");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean2");
        return mapperScannerConfigurer;
    }
}
