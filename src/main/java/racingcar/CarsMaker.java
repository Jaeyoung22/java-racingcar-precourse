package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsMaker {

    public static final String DELIMITER = ",";

    private CarsMaker() {
    }

    public static Cars make(String input) {
        String[] names = input.split(DELIMITER);
        List<Car> cars = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
