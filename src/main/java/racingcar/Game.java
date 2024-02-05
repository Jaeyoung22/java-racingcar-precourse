package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class Game {

    public static List<Car> start(List<Car> cars, Integer trialCount) {
        while (--trialCount >= 0) {
            for (Car car : cars) {
                goForWin(car);
            }
            printResult(cars);
        }
        List<Car> winners = findWinner(cars);
        return winners;
    }

    private static List<Car> findWinner(List<Car> cars) {
        Collections.sort(cars);
        Collections.reverse(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (winners.isEmpty()) {
                winners.add(car);
            } else if (winners.get(0).compareTo(car) == 0){
                winners.add(car);
            } else {
                break;
            }
        }
        return winners;
    }

    private static void printResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); ++i) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void goForWin(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.move(1);
        }
    }
}
