package cn.thinkingdata.ds.operations;
/**
 * class_name: Stop
 * package: cn.thinkingdata.ds.operations
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:38 下午
 **/
public interface Stop {
    void stop(String serverIp) throws Exception;
    void stopAll() throws Exception;
}
