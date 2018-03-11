package org.ywj.opentcc.demo.local.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.ywj.opentcc.demo.local.biz.configuration.BizConfiguration;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-11
 */
@Configuration
@Import(BizConfiguration.class)
@ComponentScan("org.ywj.opentcc.demo.local.web")
public class WebConfiguration {
}
