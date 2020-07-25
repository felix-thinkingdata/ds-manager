package cn.thinkingdata.ds.main;


import cn.thinkingdata.ds.services.DsAdminServices;
import cn.thinkingdata.ds.services.DsAutoInstallAndUpdateService;
import cn.thinkingdata.ds.services.MysqlAdminService;
import cn.thinkingdata.ds.services.SystemInitService;
import cn.thinkingdata.ds.services.ZookeeperAdminService;
import cn.thinkingdata.ds.util.CommonUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
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

    private Options options;

    private String command;
    private String host = null;

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
        if (command.equals("server init")) {
            systemInitService.initSystem(host);
        }
        if (command.equals("auto install")) {
            dsAutoInstallAndUpdateService.installAll();
        }
        if (command.equals("zookeeper install")) {
            zookeeperAdminService.installAll();
        }
        if (command.equals("mysql install")) {
            mysqlAdminService.installAll();
        }
        if (command.equals("ds install")) {
            dsAdminServices.installAll();
        }

    }

    private void initCommandOptions() {
        options = new Options();
        options.addOption("h", "help", false, "显示帮助文档并退出");
        Option hostOption = Option.builder("s").longOpt("host").argName("hostname").required(false).hasArg(true).desc("指定服务器").build();
        options.addOption(hostOption);
    }

    /**
     * 初始化命令
     *
     * @Author: Felix.Wang
     * @Date: 2019/11/5 10:00
     */
    private void init(String... args) throws ParseException, IOException {
        initCommandOptions();
        if (args == null || args.length < 1) {
            printUsage();
            System.exit(0);
        }
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        String[] realArgs = commandLine.getArgs();
        if (commandLine.hasOption("h")) {
            printUsage();
            System.exit(0);
        }
        if (commandLine.hasOption("s")) {
            host = commandLine.getOptionValue("s");
        }
        command = StringUtils.join(realArgs, " ");

    }

    private void printUsage() throws IOException {

        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp(500, "ds <命令> [选项]", CommonUtil.getContentFromResFile("/usage.txt") +
                "\n选项：\n", options, "\n示例:\n" +
                "  ds-manager zookeeper install -s hostname1   为hostname1服务器安装zookeeper服务\n" +
                "  ds-manager auto install                 安装ds服务\n" +
                "  欢迎使用DS 安装系统");
    }
}
