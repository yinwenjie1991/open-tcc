package org.ywj.opentcc.demo.local.biz.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.ywj.opentcc.demo.local.dal.configuration.DalConfiguration;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-11
 */
@Configuration
@Import({DalConfiguration.class})
@ComponentScan("org.ywj.opentcc.demo.local.biz")
public class BizConfiguration {
}
