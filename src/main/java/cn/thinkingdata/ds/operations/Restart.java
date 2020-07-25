package cn.thinkingdata.ds.operations;
/**
 * class_name: Restart
 * package: cn.thinkingdata.ds.operations
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:37 下午
 **/
public interface Restart {
    void restart(String serverIp) throws Exception;
    void restartAll() throws Exception;
}
