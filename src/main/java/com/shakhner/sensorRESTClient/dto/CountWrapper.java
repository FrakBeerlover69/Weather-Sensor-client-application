package com.shakhner.sensorRESTClient.dto;

public class CountWrapper {
    private Integer wrapper;

    public CountWrapper(Integer wrapper) {
        this.wrapper = wrapper;
    }

    public CountWrapper(){}

    public Integer getWrapper() {
        return wrapper;
    }

    public void setWrapper(Integer wrapper) {
        this.wrapper = wrapper;
    }
}
