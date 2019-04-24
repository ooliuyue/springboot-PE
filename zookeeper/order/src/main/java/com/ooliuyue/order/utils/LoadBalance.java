package com.ooliuyue.order.utils;

import java.util.List;

/**
 * @Auther: ly
 * @Date: 2019/4/22 14:00
 */

public abstract class LoadBalance {

    public volatile static List<String> SERVICE_LIST;

    public abstract String chooseServiceHost();
}
