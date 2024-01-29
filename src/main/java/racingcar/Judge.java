package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Judge {
    private static final String MESSAGE_WINNER = "최종 우승자 : ";

    private Judge() {}

    public static void announceWinners(Car[] cars) {
        String winnerNames = Arrays.stream(cars)
                .filter(Car::isWinner)
                .map(Car::getName)
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
