package BehaviouralPatterns.Observer;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(100f);
        System.out.println("Current weather station temp -> " + weatherStation.getTemp());

        Observer mobile = new MobileDevice(); // U can also keep MobileDevice mobile = new MobileDevice() but we are only using one method so i didnt care
        Observer laptop = new LaptopDevice();

        weatherStation.addObserver(mobile);
        weatherStation.addObserver(laptop);

        weatherStation.setTemp(50);
        System.out.println("\n");
        weatherStation.setTemp(200);

        weatherStation.removeObserver(mobile);

        weatherStation.setTemp(50000);

    }
}
