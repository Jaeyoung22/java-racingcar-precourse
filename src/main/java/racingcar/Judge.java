package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private final Car[] cars;

    public Judge(Car[] cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();

        int winnerPosition = 0;
        for (Car car: cars) {
            if (car.getPosition() > winnerPosition) {
                winners.clear();
                winners.add(car);
                continue;
            }
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
