package com.lvcaiRPC.starter;

import com.lvcaiRPC.consumer.ConsumerProxy;
import com.lvcaiRPC.producer.PhoneService;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 16:11
 */
public class ConsumerMain {
    public static void main(String[] args) {
        // 消费者 调用服务,返回结果
        // 消费者代理对象将请求参数封装成协议,发出去,服务端接受后,解析协议,执行对应方法,将结果封装为协议响应回来

        PhoneService proxy = ConsumerProxy.getProxy(PhoneService.class, "127.0.0.1", 8080);
        System.out.println(proxy.phoneName("huawei :lvcai "));
    }
}
