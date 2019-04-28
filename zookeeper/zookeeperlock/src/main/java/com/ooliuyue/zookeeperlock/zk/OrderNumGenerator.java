package com.ooliuyue.zookeeperlock.zk;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Auther: ly
 * @Date: 2019/4/25 14:34
 */

public class OrderNumGenerator {

    private static int count = 0;

    public String getNumber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return simpleDateFormat.format(new Date()) + "-" + ++count;
    }

}
