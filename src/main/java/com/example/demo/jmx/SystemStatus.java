package com.example.demo.jmx;

public class SystemStatus implements SystemStatusMBean {

    private String data;

    @Override
    public String getLatestData() {
        return this.data;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String setData(String data) {
        this.data = data;
        return this.data;
    }

}