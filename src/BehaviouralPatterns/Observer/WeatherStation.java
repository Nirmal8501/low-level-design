package BehaviouralPatterns.Observer;


public class WeatherStation implements WeatherStationPublisher {
    private float temp;

    public WeatherStation(float temp) {
        this.temp = temp;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
        announceChange(temp);
    }

}
