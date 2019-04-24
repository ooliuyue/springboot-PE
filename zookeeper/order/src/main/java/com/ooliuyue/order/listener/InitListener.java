package com.ooliuyue.order.listener;

import com.ooliuyue.order.utils.LoadBalance;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ly
 * @Date: 2019/4/19 16:26
 */

public class InitListener implements ServletContextListener {

    private  static final String BASE_SERVICE = "/service";
    private  static final String SERVICE_NAME = "/product";
    private ZooKeeper zooKeeper;

    private void init(){
        try {
            //连接zk,获得列表信息
            //watcher机制：监控获取到的服务列表的变化
            zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,(watchedEvent) -> {
                if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                        && watchedEvent.getPath().equals(BASE_SERVICE+SERVICE_NAME)) {
                    System.out.println("***注册到zk的服务信息发生变化***");
                    updateServerList();
                }
            });
            //第一次连接的时候要返回的列表
            updateServerList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateServerList() {
        List<String> list = new ArrayList<>();
        try {
            List<String> children = zooKeeper.getChildren(BASE_SERVICE + SERVICE_NAME,true);
            for(String subNode : children) {
                byte[] data = zooKeeper.getData(BASE_SERVICE + SERVICE_NAME + "/" + subNode, false, null);
                String host  = new String(data,"utf-8");
                list.add(host);
            }
            //将获取的服务端口和IP保存List中
            LoadBalance.SERVICE_LIST = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void  contextInitialized(ServletContextEvent sce) {
        init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }


}
