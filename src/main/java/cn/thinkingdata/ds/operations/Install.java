package cn.thinkingdata.ds.operations;
/**
 * class_name: Install
 * package: cn.thinkingdata.ds.operations
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:37 下午
 **/
public interface Install {
    void install(String serverIp) throws Exception;
    void installAll() throws Exception;
}
