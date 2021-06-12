package com.example.demo.jmx;

public interface SystemStatusMBean {

    String getLatestData();
    String getData();
    String setData(String data);
}
