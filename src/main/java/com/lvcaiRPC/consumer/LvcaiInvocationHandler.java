package com.lvcaiRPC.consumer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 16:36
 */
public class LvcaiInvocationHandler implements InvocationHandler {
    private String host;
    private int port;
    public LvcaiInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());){


            Protocol requestProtocol = Protocol.builder()
                    .interfaceName(method.getDeclaringClass().getName())//对应的接口名
                    .methodName(method.getName())//方法名
                    .paramTypes(method.getParameterTypes())//入参类型
                    .parameters(args).build();//入参
            objectOutputStream.writeObject(requestProtocol);
            Object result = objectInputStream.readObject();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("调用服务异常,异常信息是: "+e.getMessage());
        }
    }
}
