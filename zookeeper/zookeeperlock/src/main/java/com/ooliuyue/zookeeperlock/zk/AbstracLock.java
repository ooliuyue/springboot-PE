package com.ooliuyue.zookeeperlock.zk;

/**
 * @Auther: ly
 * @Date: 2019/4/25 11:31
 */

public abstract class AbstracLock implements Lock {

    public void getLock() {
        //尝试获得锁资源
        if (tryLock()) {
            System.out.println("##获取Lock锁的资源##");
        } else {
            //等待（监控）
            waitLock();
            //重新获取锁
            getLock();
        }
    }

    public abstract boolean tryLock();
    public abstract void waitLock();
}
