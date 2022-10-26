package com.shakhner.sensorRESTClient.dto.response.responseListWrappers;

import com.shakhner.sensorRESTClient.dto.response.MeasurementResponseByLocation;

import java.util.List;

public class MeasurementsByLocationResponse {
    private List<MeasurementResponseByLocation> response;

    public MeasurementsByLocationResponse(List<MeasurementResponseByLocation> response) {
        this.response = response;
    }

    public MeasurementsByLocationResponse() {
    }

    public List<MeasurementResponseByLocation> getResponse() {
        return response;
    }

    public void setResponse(List<MeasurementResponseByLocation> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "MeasurementsByLocationResponse{" +
                "response=" + response +
                '}';
    }
}
