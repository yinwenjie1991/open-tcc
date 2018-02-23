package org.ywj.opentcc.dal.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import org.ywj.opentcc.common.util.StringUtil;
import org.ywj.opentcc.dal.config.TccDBConfig;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-02
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.ywj.opentcc.dal")
@EnableTransactionManagement
@PropertySource(value = "classpath:open-tcc-db.properties", ignoreResourceNotFound = true)
public class DaoConfiguration {

    @Value("${tcc_jdbc_url}")
    private String tccJdbcUrl;

    @Value("${tcc_jdbc_user}")
    private String tccJdbcUser;

    @Value("${tcc_jdbc_password}")
    private String tccJdbcPassword;

    @Value("${tcc_tb_name}")
    private String tccTbName;

    @Value("${tcc_region_name}")
    private String tccRegion;

    @Bean(name = "tccDruidDataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource tccDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //到时候采用properties来配置
        dataSource.setUrl(tccJdbcUrl);
        dataSource.setUsername(tccJdbcUser);
        dataSource.setPassword(tccJdbcPassword);
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

    @Bean(name = "tccSqlSessionFactory")
    public SqlSessionFactory tccSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(tccDruidDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:META-INF/mappers/manual/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("org.ywj.opentcc.dao.entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "tccTransactionManager")
    public PlatformTransactionManager tccTransactionManager() {
        return new DataSourceTransactionManager(tccDruidDataSource());
    }

    @Bean(name = "tccTransactionTemplate")
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(tccTransactionManager());
        return transactionTemplate;
    }

    @Bean
    public TccDBConfig tccDBConfig() {
        TccDBConfig tccDBConfig = new TccDBConfig();
        if (!StringUtil.isEmpty(tccTbName)) {
            tccDBConfig.setTTCTB_NAME(tccTbName);
        }
        if (!StringUtil.isEmpty(tccRegion)) {
            tccDBConfig.setREGION(tccRegion);
        }
        return tccDBConfig;
    }
}
