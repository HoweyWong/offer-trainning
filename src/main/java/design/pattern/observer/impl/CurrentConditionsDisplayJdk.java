package design.pattern.observer.impl;

import design.pattern.observer.subject.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayJdk implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    Observable observable;

    public CurrentConditionsDisplayJdk(Observable observable) {
        this.observable = observable;
        // 构造器注册观察者
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJdk) {
            WeatherDataJdk weatherData = (WeatherDataJdk) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
