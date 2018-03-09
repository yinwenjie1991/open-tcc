package org.ywj.opentcc.demo.local.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-09
 */
@SpringBootApplication
@PropertySource(value = {"classpath*:open-tcc-db.properties"}, ignoreResourceNotFound = true)
//@Import()
public class ApplicationRunner extends WebMvcConfigurerAdapter {

    private String webRoot = "file:" + System.getProperty("user.dir") + "/open-tcc-demo/webroot/assets/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations(webRoot);
    }

    public static void main(String[] args) {
        System.setProperty("server.port" , "8088");
        SpringApplication.run(ApplicationRunner.class , args);
    }
}
