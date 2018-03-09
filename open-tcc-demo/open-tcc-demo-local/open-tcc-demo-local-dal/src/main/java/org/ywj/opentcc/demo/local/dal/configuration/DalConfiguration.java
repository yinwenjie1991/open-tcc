package org.ywj.opentcc.demo.local.dal.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-09
 */
@Configuration
@ComponentScan("org.ywj.opentcc.demo.local.dal")
@EnableTransactionManagement
@MapperScan("org.ywj.opentcc.demo.local.dal.mapper.auto")
@PropertySource(value = "classpath:demo-db.properties", ignoreResourceNotFound = true)
public class DalConfiguration {

    @Value("${tcc_demo_db1_url}")
    private String db1Url;

//    @Value()
    private String db1User;

    private String db1Password;

}
