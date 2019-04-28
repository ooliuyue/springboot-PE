package com.ooliuyue.zookeeperlock.zk;

import org.I0Itec.zkclient.IZkDataListener;

import javax.management.monitor.CounterMonitor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: ly
 * @Date: 2019/4/26 10:55
 */

public class ZookeeperDistrbuteLock2 extends ZookeeperAbstractLock {
    private CountDownLatch countDownLatch = null;

    private String beforePath; //当前线程的节点前一个节点
    private String currentPath; //当前线程的节点

    public ZookeeperDistrbuteLock2(){
        if (!this.zkClient.exists(PATH2)) {
            this.zkClient.createPersistent(PATH2);
        }
    }

    @Override
    public boolean tryLock() {
        //如果currentPath为空则为当前线程尝试加锁
        if (currentPath == null || currentPath.length() <= 0) {
            //创建一个临时顺序节点
            currentPath = this.zkClient.createEphemeralSequential(PATH2 + '/',"lock");
            System.out.println("当前线程的锁为===" + currentPath);
        }
        //获取所有临时节点并排序，临时节点名称为自增长字符串如：/lock2/0000000004
        List<String> children = this.zkClient.getChildren(PATH2);
        Collections.sort(children);

        //如果当前线程节点在所有节点中排名第一则获取锁成功
        if (currentPath.equals(PATH2 + '/' + children.get(0))) {
            System.out.println(currentPath + "===节点获取锁成功");
            return true;
        } else {
            //如果当前线程节点在所有节点中不是排第一，则获取前面的节点名称，并赋值给beforePath
            int i = Collections.binarySearch(children, currentPath.substring(7));
            beforePath = PATH2 + '/' + children.get(i - 1);
        }
        return false;
    }

    @Override
    public void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }

            }
        };
        //给排在前面的节点增加数据删除的watcher,（启动另外一个线程去监听它）
        System.out.println(currentPath + "===监控beforPath===" + beforePath);
        this.zkClient.subscribeDataChanges(beforePath,iZkDataListener);

        if (this.zkClient.exists(beforePath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                //监听线程执行完毕后删除监听
                countDownLatch.await();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

        this.zkClient.unsubscribeDataChanges(beforePath,iZkDataListener);


    }

    @Override
    public void unLock() {
        System.out.println(currentPath + "===释放锁资源...");
        zkClient.delete(currentPath);
        zkClient.close();


    }
}
