package com.ooliuyue.zookeeperlock.zk;

import org.I0Itec.zkclient.IZkDataListener;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: ly
 * @Date: 2019/4/25 11:45
 */

public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
    private CountDownLatch countDownLatch = null;

    @Override
    //尝试获得锁
    public boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            System.out.println("当前线程获取锁" + PATH + "成功");
            return true;
        } catch (Exception e) {
            //如果创建失败抛出异常
//            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void waitLock() {
        /*当前节点数据内容或版本发生变化或者当前节点被删除，触发当前接口 */
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String path, Object o) throws Exception {

            }

            @Override
            /* 删除当前节点，触发该接口通知。此时，path即当前节点路径 */
            public void handleDataDeleted(String path) throws Exception {
                //唤醒被等待的线程
                if (countDownLatch != null ) {
                    countDownLatch.countDown();
                }

            }
        };
        //监听节点PATH的变化
        zkClient.subscribeDataChanges(PATH,iZkDataListener);

        //如果节点存在
        if (zkClient.exists(PATH)) {
            countDownLatch = new CountDownLatch(1);
            try {
                //等待，一直到监听器发起删除节点的通知，表示锁释放
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //删除监听
        zkClient.unsubscribeDataChanges(PATH,iZkDataListener);
    }

    public void unLock() {
        //释放锁
        if (zkClient != null) {
            zkClient.delete(PATH);
            zkClient.close();
            System.out.println("释放锁资源。。");
        }

    }
}
