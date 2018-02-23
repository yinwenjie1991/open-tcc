package org.ywj.opentcc.core.configutation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.ywj.opentcc.dal.configuration.DaoConfiguration;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Import({DaoConfiguration.class})
@ComponentScan("org.ywj.opentcc.core")
@Configuration
@EnableAspectJAutoProxy
public class TccCoreConfiguration {


}
