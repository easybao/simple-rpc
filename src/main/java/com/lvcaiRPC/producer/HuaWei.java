package com.lvcaiRPC.producer;

public class HuaWei implements PhoneService{

    @Override
    public String phoneName(String name) {
        return "华为手机: "+name;
    }
}