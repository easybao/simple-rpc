package com.lvcaiRPC.starter;

import com.lvcaiRPC.producer.HuaWei;
import com.lvcaiRPC.producer.PhoneService;
import com.lvcaiRPC.producer.RequestProtocolHandler;
import com.lvcaiRPC.producer.ServiceMapLv;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 16:10
 */
public class ProducerMain {

    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
            5, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws IOException {
        PhoneService phone = new HuaWei();
        ServiceMapLv.put(PhoneService.class.getName(),phone);

        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("接受到请求");
            threadPoolExecutor.execute(new RequestProtocolHandler(accept));
        }
    }

}
