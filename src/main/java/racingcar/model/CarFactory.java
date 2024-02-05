package racingcar.model;

public class CarFactory {
    public static Car create(String name) {
        return new Car(name);
    }
}
