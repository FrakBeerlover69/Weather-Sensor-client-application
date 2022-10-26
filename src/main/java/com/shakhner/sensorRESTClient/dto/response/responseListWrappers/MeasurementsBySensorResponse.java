package com.shakhner.sensorRESTClient.dto.response.responseListWrappers;

import com.shakhner.sensorRESTClient.dto.response.MeasurementResponseBySensor;

import java.util.List;

public class MeasurementsBySensorResponse {

    private List<MeasurementResponseBySensor> measurements;

    public MeasurementsBySensorResponse() {
    }

    public MeasurementsBySensorResponse(List<MeasurementResponseBySensor> measurements) {
        this.measurements = measurements;
    }

    public List<MeasurementResponseBySensor> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementResponseBySensor> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "MeasurementsBySensorResponse{" +
                "measurements=" + measurements +
                '}';
    }
}
