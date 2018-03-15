package org.ywj.opentcc.demo.local.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.ywj.opentcc.demo.local.web.configuration.WebConfiguration;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-09
 */
@SpringBootApplication
@PropertySource(value = {"classpath*:demo-db.properties",
        "classpath*:open-tcc-db.properties"}, ignoreResourceNotFound = true)
//@PropertySource(value = {"classpath*:open-tcc-db.properties"}, ignoreResourceNotFound = true)
@Import(WebConfiguration.class)
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class , args);
    }
}
