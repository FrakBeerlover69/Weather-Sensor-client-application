package com.shakhner.sensorRESTClient.dto.response.responseListWrappers;


import com.shakhner.sensorRESTClient.dto.MeasurementDTO;

import java.util.List;

public class MeasurementsDTOResponse {
    private List<MeasurementDTO> measurements;

    public MeasurementsDTOResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

    public MeasurementsDTOResponse(){}

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "MeasurementsDTOResponse{" +
                "measurements=" + measurements +
                '}';
    }
}
