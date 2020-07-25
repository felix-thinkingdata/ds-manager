package cn.thinkingdata.ds.services;

import cn.thinkingdata.ds.operations.Install;
import cn.thinkingdata.ds.operations.Restart;
import cn.thinkingdata.ds.operations.Start;
import cn.thinkingdata.ds.operations.Stop;
import cn.thinkingdata.ds.operations.UpdateConf;
import org.springframework.stereotype.Service;
/**
 * class_name: DsAdminServices
 * package: cn.thinkingdata.ds.services
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:38 下午
 **/
@Service
public class DsAdminServices implements Install, Stop, Start, Restart, UpdateConf{
    @Override
    public void install(String serverIp) throws Exception {

    }

    @Override
    public void installAll() throws Exception {

    }

    @Override
    public void restart(String serverIp) throws Exception {

    }

    @Override
    public void restartAll() throws Exception {

    }

    @Override
    public void start(String serverIp) throws Exception {

    }

    @Override
    public void startAll() throws Exception {

    }

    @Override
    public void stop(String serverIp) throws Exception {

    }

    @Override
    public void stopAll() throws Exception {

    }

    @Override
    public void upconf(String serverIp) throws Exception {

    }

    @Override
    public void upconfAll() throws Exception {

    }
}
