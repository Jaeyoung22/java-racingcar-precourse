package racingcar;

import racingcar.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {

    private static final List<String> winner = new ArrayList<>();
    private static final List<Integer> allPositions = new ArrayList<>();
    public static int getMax(ArrayList<Car> cars) {
        for (Car c : cars) {
            allPositions.add(c.getPosition());
        }
        return Collections.max(allPositions);
    }

    public static void findWinner(ArrayList<Car> cars) {
        for (Car c : cars) {
            if (c.getPosition()==getMax(cars)) {
                winner.add(c.getName());
            }
        }
    }

    public static void printWinner() {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winner));
    }
}
