package cn.thinkingdata.ds.properties;

import cn.thinkingdata.ds.util.CommonUtil;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import static cn.thinkingdata.ds.constants.DsContants.INSTALL_PROPERTIES;

/**
 * class_name: DsPropertiesFactory
 * package: cn.thinkingdata.ds.properties
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:37 下午
 **/
public class DsPropertiesFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String value, EncodedResource encodedResource) throws IOException {
        String installPropertyContent = CommonUtil.getContentFromFile(INSTALL_PROPERTIES);
        Properties installProperties = new Properties();
        installProperties.load(new StringReader(installPropertyContent));
        return new PropertiesPropertySource("ds"+value, installProperties);
    }
}
