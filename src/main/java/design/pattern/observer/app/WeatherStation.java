package design.pattern.observer.app;

import design.pattern.observer.impl.CurrentConditionsDisplay;
import design.pattern.observer.impl.CurrentConditionsDisplayJdk;
import design.pattern.observer.impl.WeatherData;
import design.pattern.observer.impl.WeatherDataJdk;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 32.4f);
        weatherData.setMeasurements(78, 95, 29.4f);

        WeatherDataJdk weatherDataJdk = new WeatherDataJdk();
        CurrentConditionsDisplayJdk currentConditionsDisplayJdk = new CurrentConditionsDisplayJdk(weatherDataJdk);
        weatherDataJdk.setMeasurements(85, 75, 30.5f);
        weatherDataJdk.setMeasurements(86, 76, 30.6f);
        weatherDataJdk.setMeasurements(87, 77, 30.7f);
    }
}
