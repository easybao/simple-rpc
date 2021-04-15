package com.lvcaiRPC.consumer;

import java.lang.reflect.Proxy;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 16:33
 */
public class ConsumerProxy {
    public static <T> T getProxy(final Class<T> interfaceClass,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},new LvcaiInvocationHandler(host,port));
    }
}
