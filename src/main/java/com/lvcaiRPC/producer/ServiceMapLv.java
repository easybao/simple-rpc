package com.lvcaiRPC.producer;

import com.lvcaiRPC.producer.PhoneService;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 17:10
 */
public class ServiceMapLv {
    private static Map<String,Object> map = new HashMap<>();
    public static void put(String name, PhoneService phone) {
        map.put(name,phone);
    }

    public static Object get(String name){
        return map.get(name);
    }
}
