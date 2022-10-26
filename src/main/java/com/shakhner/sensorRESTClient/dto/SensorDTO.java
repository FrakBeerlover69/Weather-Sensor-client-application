package com.shakhner.sensorRESTClient.dto;


public class SensorDTO {
    private String name;

    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SensorDTO{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
