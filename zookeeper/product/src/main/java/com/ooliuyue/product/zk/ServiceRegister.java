package com.ooliuyue.product.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;


/**
 * @Auther: ly
 * @Date: 2019/4/19 11:53
 */

public class ServiceRegister {

    private  static final String BASE_SERVICE = "/service";
    private  static final String SERVICE_NAME = "/product";

    public static void register(String address,int port) {
        /**
         * 在zk创建根节点path,在根节点下创建临时子节点用于存放服务ip和端口
         */
        try {
            String path = BASE_SERVICE + SERVICE_NAME;
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,(watchedEvent) -> {});
            System.out.println(zooKeeper);
            Thread.sleep(2000);
            Stat exists = zooKeeper.exists(BASE_SERVICE + SERVICE_NAME, false);
            //先判断服务根路径是否存在
            if (exists == null){
                zooKeeper.create(BASE_SERVICE + SERVICE_NAME,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            //将服务的ip和端口作为临时带序号的子节点
            String server_path = address+":"+port;
            zooKeeper.create(path + "/child",server_path.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("product服务注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
