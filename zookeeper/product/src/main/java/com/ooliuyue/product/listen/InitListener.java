package com.ooliuyue.product.listen;

import com.ooliuyue.product.zk.ServiceRegister;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetAddress;
import java.util.Properties;

/**
 * @Auther: ly
 * @Date: 2019/4/19 10:43
 */

public class InitListener implements ServletContextListener {

    @Override
    //容器初始化的时候会调用
    public void  contextInitialized(ServletContextEvent sce) {
        Properties properties = new Properties();
        try {
            properties.load(InitListener.class.getClassLoader().getResourceAsStream("application.properties"));
            //获得IP
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            //获得端口
            int port = Integer.valueOf(properties.getProperty("server.port"));
            ServiceRegister.register(hostAddress,port);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
