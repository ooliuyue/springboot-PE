package com.ooliuyue.order.utils;

import org.springframework.util.CollectionUtils;

import java.util.Random;

/**
 * @Auther: ly
 * @Date: 2019/4/22 14:02
 */

//实现了一个随机的算法（随机获取订单服务）
public class RandomLoadBalance extends LoadBalance {


    @Override
    public String chooseServiceHost() {
        String result = "";
        if (!CollectionUtils.isEmpty(SERVICE_LIST)) {
            int nextInt = new Random().nextInt(SERVICE_LIST.size());
            result = SERVICE_LIST.get(nextInt);
        }
        return result;
    }
}
