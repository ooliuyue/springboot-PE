package com.ooliuyue.zookeeperlock.zk;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: ly
 * @Date: 2019/4/25 14:39
 */

public class OrderService implements Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private Lock lock = new ZookeeperDistrbuteLock();



    @Override
    public void run() {
        getNum();
    }

    public void getNum() {
        try {
            lock.getLock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",生产订单ID:" + number);
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }



    public static void main(String[] args) {
        System.out.println("##生产唯一订单号##");
        for (int i = 0; i < 10 ; i++) {
            new Thread(new OrderService()).start();
        }
    }
}
