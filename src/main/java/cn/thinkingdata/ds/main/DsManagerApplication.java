package cn.thinkingdata.ds.main;


import cn.thinkingdata.ds.services.DsAdminServices;
import cn.thinkingdata.ds.services.DsAutoInstallAndUpdateService;
import cn.thinkingdata.ds.services.MysqlAdminService;
import cn.thinkingdata.ds.services.SystemInitService;
import cn.thinkingdata.ds.services.ZookeeperAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

/**
 * class_name: DsManagerApplication
 * package: cn.thinkingdata.ds.main
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:37 下午
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"cn.thinkingdata.ds"}, lazyInit = true)
public class DsManagerApplication implements CommandLineRunner {

    private static final String VERSION = "1.0.0";

    private static final Logger consoleLog = LoggerFactory.getLogger(DsManagerApplication.class);

    @Autowired
    DsAdminServices dsAdminServices;

    @Autowired
    DsAutoInstallAndUpdateService dsAutoInstallAndUpdateService;

    @Autowired
    MysqlAdminService mysqlAdminService;

    @Autowired
    SystemInitService systemInitService;

    @Autowired
    ZookeeperAdminService zookeeperAdminService;

    public static void main(String[] args) {
        try {
            SpringApplication app = new SpringApplication(DsManagerApplication.class);
            app.setBannerMode(Banner.Mode.OFF);
            app.run(args);
        } catch (Exception e) {
            consoleLog.error("init error ", e);
            throw e;
        }
    }


    @Override
    public void run(String... args) throws Exception {
        init(args);


    }

    /**
     * 初始化命令
     *
     * @Author: Felix.Wang
     * @Date: 2019/11/5 10:00
     */
    private void init(String... args) {

    }


}
