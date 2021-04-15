package com.lvcaiRPC.producer;

import com.lvcaiRPC.consumer.Protocol;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 17:03
 */
public class RequestProtocolHandler implements Runnable {
    Socket socket;
    public RequestProtocolHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

            Protocol protocol = (Protocol) inputStream.readObject();
            Object service = ServiceMapLv.get(protocol.getInterfaceName());
            Method method = service.getClass().getMethod(protocol.getMethodName(), protocol.getParamTypes());
            Object result = method.invoke(service,  protocol.getParameters());
            outputStream.writeObject(result);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("服务端处理请求异常:  "+ e.getMessage());
        }
    }
}
