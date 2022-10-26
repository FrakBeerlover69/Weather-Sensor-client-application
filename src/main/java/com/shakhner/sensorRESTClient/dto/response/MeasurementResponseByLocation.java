package com.shakhner.sensorRESTClient.dto.response;


public class MeasurementResponseByLocation {
    private Double temperatureValue;

    private Boolean raining;

    private Double windSpeed;

    private String locationOfMeasurement;

    private String timeOfMeasurement;

    private SensorResponse sensor;


    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getTimeOfMeasurement() {
        return timeOfMeasurement;
    }

    public void setTimeOfMeasurement(String timeOfMeasurement) {
        this.timeOfMeasurement = timeOfMeasurement;
    }

    public String getLocationOfMeasurement() {
        return locationOfMeasurement;
    }

    public void setLocationOfMeasurement(String locationOfMeasurement) {
        this.locationOfMeasurement = locationOfMeasurement;
    }

    public SensorResponse getSensor() {
        return sensor;
    }

    public void setSensor(SensorResponse sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "MeasurementResponseByLocation{" +
                "temperatureValue=" + temperatureValue +
                ", raining=" + raining +
                ", windSpeed=" + windSpeed +
                ", locationOfMeasurement='" + locationOfMeasurement + '\'' +
                ", timeOfMeasurement='" + timeOfMeasurement + '\'' +
                ", sensor=" + sensor +
                '}';
    }
}
