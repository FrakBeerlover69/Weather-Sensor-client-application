package com.shakhner.sensorRESTClient;

import com.shakhner.sensorRESTClient.dto.MeasurementDTO;
import com.shakhner.sensorRESTClient.dto.SensorDTO;
import com.shakhner.sensorRESTClient.dto.response.responseListWrappers.MeasurementsByLocationResponse;
import com.shakhner.sensorRESTClient.dto.response.responseListWrappers.MeasurementsBySensorResponse;
import com.shakhner.sensorRESTClient.dto.response.responseListWrappers.SensorsDTOResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.tomcat.util.net.SocketEvent.TIMEOUT;


public class Client {
    public static void main(String[] args) throws ParseException {

        System.out.println(getRainyDaysCountForLocation("Warszawa"));
    }


    private static Integer getRainyDaysCountForLocation(String location){
        final String url = "http://localhost:8080/measurement/getRainyDaysCountForLocation?location=" + location;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, Integer.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static MeasurementsByLocationResponse getDataForLocationAndDate(String location, String from, String to){
        final String url = "http://localhost:8080/measurement/getDataForLocationAndDate?location=" + location +
                "&from=" + from + "&to=" + to;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, MeasurementsByLocationResponse.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static Integer getRainyDaysCountForSensorsName(String name){
        final String url = "http://localhost:8080/measurement/getRainyDaysCountForSensorsName?name=" + name;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, Integer.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static MeasurementsByLocationResponse getMeasurementsByLocation(String location){
        final String url = "http://localhost:8080/measurement/getDataForLocation?location=" + location;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, MeasurementsByLocationResponse.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static MeasurementsBySensorResponse getMeasurementsBySensor(String sensorName){
        final String url = "http://localhost:8080/measurement/getDataForSensorsName?sensorName=" + sensorName;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, MeasurementsBySensorResponse.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static void addMeasurement(Double temperatureValue, Boolean raining, Double windSpeed, String sensorName) throws ParseException {
        final String url = "http://localhost:8080/measurement/add";
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");


        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("temperatureValue", temperatureValue);
        jsonData.put("raining", raining);
        jsonData.put("windSpeed", windSpeed);
        jsonData.put("timeOfMeasurement", format.format(new Date()));
        jsonData.put("sensor", Map.of("name", sensorName));

        doPostRequestWithJSONData(url, jsonData);

    }

    private static void updateLocation(String name, String location){
        final String url = "http://localhost:8080/sensor/" + name + "/updatelocation";

        final RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(Map.of("location", location), headers);

        try{
            template.patchForObject(url, request, String.class);
            System.out.println("location was changed");
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteSensor(String sensorName){
        final String url = "http://localhost:8080/sensor/" + sensorName + "/delete";

        final RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        try {
            restTemplate.delete(url);
            System.out.println("Sensor was deleted successful");
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }


    }

    private static void registerNewSensor(String sensorName, String location){
        final String url = "http://localhost:8080/sensor/register";

        Map<String, Object> jsonDATA = new HashMap<>();

        jsonDATA.put("name", sensorName);
        jsonDATA.put("location", location);

        doPostRequestWithJSONData(url, jsonDATA);

    }

    private static SensorDTO findById(Integer id){
        final String url = "http://localhost:8080/sensor/" + id;
        final RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.getForObject(url, SensorDTO.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getCause() + e.getMessage());
            return null;
        }
    }

    private static SensorDTO findByName(String name){
        final String url = "http://localhost:8080/sensor/findByName?name=" + name;
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(url, SensorDTO.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getCause() + e.getMessage());
            return null;
        }
    }

    private static SensorsDTOResponse findAllSensors(){
        final String url = "http://localhost:8080/sensor";
        final RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, SensorsDTOResponse.class);
    }

    private static void doPostRequestWithJSONData(String url, Map<String,Object> jsonDATA){
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonDATA, headers);

        try{
            restTemplate.postForObject(url, request, String.class);

            System.out.println("Change completed successfully!");
        }catch (HttpClientErrorException e){
            System.out.println(e.getCause() + e.getMessage());
        }
    }
}
