package BehaviouralPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public interface WeatherStationPublisher {
//    Its better to not give default methods here if u wish to re-use the Publisher with a generic name like Subject or Publisher,
//    So just have method name here and implement in parent class, or add a middleware abstract class in between, depends

    List<Observer> observers = new ArrayList<>();

    default void announceChange(float temp) {
        for (var observer : observers) {
            observer.update(temp);
        }
    }

    default void addObserver(Observer observer) {
        observers.add(observer);
    }

    default void removeObserver(Observer observer) {
        observers.remove(observer);  // Or each observer can have a getName function or a unique Id maybe and them remove that, possibilities are endless but for simplicity lets just keep this n call it a day.
    }
}
