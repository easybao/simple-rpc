package com.lvcaiRPC.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @@menu <p>
 * @date 2021/4/15 16:21
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Protocol implements Serializable {
    // 自定义传输协议
    // 接口名
    private String interfaceName;
    // 方法名
    private String methodName;
    //参数类型
    private Class<?>[] paramTypes;
    // 入参
    private Object[] parameters;
}
