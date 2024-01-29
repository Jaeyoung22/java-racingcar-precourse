package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Judge {
    private static final String MESSAGE_WINNER = "최종 우승자 : ";

    private Judge() {}

    public static void announceWinners(Car[] cars) {
        String winnerNames = Arrays.stream(cars)
                .filter(car -> car.isWinner())
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));

        System.out.println(MESSAGE_WINNER + winnerNames);
    }

    public static void markWinners(Car[] cars) {
        int winnerPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > winnerPosition) {
                winnerPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                car.setWinner(true);
            }
        }
    }

}
