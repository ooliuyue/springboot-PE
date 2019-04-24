> 最近在学习zookeeper，作为一个分布式协调服务，它的用途挺多，服务注册与发现、分布式锁、集群选举、配置中心等。今天我先通过一个demo实现zookeeper的服务注册与发现功能

### 思路

![zookeeper服务注册与发现](https://user-gold-cdn.xitu.io/2019/4/23/16a4953cc043fd9b?w=755&h=378&f=png&s=51531)

* 将产品服务的信息注册到zookeeper的节点上
* 然后获取到节点上的信息并存储起来（本文存到List）
* Watcher机制监控List里数据的变化并更新数据 （假如产品服务2挂了通过监听机制将其移出）
* 利用轮询或者hash等算法去获取List里的数据供订单服务调用（负载均衡）
![zk节点](https://user-gold-cdn.xitu.io/2019/4/23/16a4953cc09de288?w=520&h=409&f=png&s=9184)
