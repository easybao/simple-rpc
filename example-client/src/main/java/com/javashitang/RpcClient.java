package com.javashitang;


import com.javashitang.proxy.ConsumerProxy;

public class RpcClient {

    public static void main( String[] args ) {
        // 获取代理类
        StudentService studentService = ConsumerProxy.getProxy(StudentService.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(studentService.getStudentInfo(10));
        }
    }
}
