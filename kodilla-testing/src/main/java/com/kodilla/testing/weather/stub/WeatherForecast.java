package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAvg(){
        double sum = 0.0;
        for (Map.Entry<String, Double> temp : temperatures.getTemperatures().entrySet()){
            sum += temp.getValue();
        }
        int mapSize = temperatures.getTemperatures().size();;
        return mapSize == 0 ? 0.0 : 1.0 * sum / mapSize;
    }

    public double calculateMedian(){
        ArrayList<Double> tempData = new ArrayList<>();
        for (Map.Entry<String, Double> temp : temperatures.getTemperatures().entrySet()){
            tempData.add(temp.getValue());
        }
        Collections.sort(tempData);
        double median;
        int mid = tempData.size()/2;
        if (tempData.size() % 2 == 0){
            median = (tempData.get(mid - 1) + tempData.get(mid))/2;
        } else {
            median = tempData.get(mid);
        }
        return median;
    }
}