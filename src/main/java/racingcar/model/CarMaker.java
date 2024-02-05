package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarMaker {

    public static List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름이 빈 값이거나 5글자를 초과합니다.");
            }
            cars.add(CarFactory.create(carName));
        }
        return cars;
    }

}
