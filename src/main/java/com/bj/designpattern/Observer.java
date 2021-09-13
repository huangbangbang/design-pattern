package com.bj.designpattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Observer {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("36","1000","900");
        WeatherObserver baidu = new Baidu();
        WeatherObserver sina = new Sina();
        weatherData.registerObserver(baidu);
        weatherData.registerObserver(sina);
        weatherData.notifyObservers();
        weatherData.setHumid("400");
        weatherData.setTemperature("40");
        weatherData.setPressure("1200");
        /*baidu.getWeatherCondition();
        sina.getWeatherCondition();*/

    }
}

interface Weather {

    void registerObserver(WeatherObserver weatherObserver);

    void removeObserver(WeatherObserver weatherObserver);

    void notifyObservers();
}

class WeatherData implements Weather {
    private String temperature;
    private String pressure;
    private String humid;

    public WeatherData(String temperature, String pressure, String humid) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humid = humid;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
        notifyObservers();
    }

    public void setHumid(String humid) {
        this.humid = humid;
        notifyObservers();
    }

    private ArrayList<WeatherObserver> arrayList =new ArrayList<>();

    @Override
    public void registerObserver(WeatherObserver weatherObserver) {
        this.arrayList.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        this.arrayList.remove(weatherObserver);
    }

    @Override
    public void notifyObservers() {
        Iterator<WeatherObserver> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            WeatherObserver weatherObserver = iterator.next();
            weatherObserver.update(this.temperature,this.pressure,this.humid);
        }
    }
}

interface WeatherObserver{
    void update(String temperature, String pressure, String humid);
    void getWeatherCondition();
}

class Baidu implements WeatherObserver {
    private String temperature;
    private String pressure;
    private String humid;

    @Override
    public void update(String temperature, String pressure, String humid) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humid = humid;
        getWeatherCondition();
    }
    public void getWeatherCondition(){
        System.out.println("baidu receive update: temperature is "+temperature+" pressure is "+pressure+" humid is "+humid);
    }
}

class Sina implements WeatherObserver {
    private String temperature;
    private String pressure;
    private String humid;

    @Override
    public void update(String temperature, String pressure, String humid) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humid = humid;
        getWeatherCondition();
    }
    public void getWeatherCondition(){
        System.out.println("sina receive update: temperature is "+temperature+" pressure is "+pressure+" humid is "+humid);
    }
}