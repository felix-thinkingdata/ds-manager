package cn.thinkingdata.ds.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * class_name: DsInstallProperties
 * package: cn.thinkingdata.ds.properties
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:38 下午
 **/
@Configuration
@PropertySource(value = "", factory = DsPropertiesFactory.class)
public class DsInstallProperties {
    @Value("${total.hosts}")
    public String totalHosts;
}
