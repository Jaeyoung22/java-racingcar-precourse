package racingcar;

import racingcar.io.AttemptsInputHandler;
import racingcar.io.NamesInputHandler;

public class Race {

    private static final String MESSAGE_RESULTS = "실행 결과";

    public static Race createRace() {
        NamesInputHandler namesInputHandler = new NamesInputHandler();
        AttemptsInputHandler attemptsInputHandler = new AttemptsInputHandler();

        String[] names = namesInputHandler.readInput();
        Integer attempts = attemptsInputHandler.readInput();

        return new Race(names, attempts);
    }


    private final Car[] cars;
    private final int attempts;

    private Race(String[] names, int attempts) {
        this.attempts = attempts;

        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    public void start() {
        System.out.println(MESSAGE_RESULTS);
        for (int i = 0; i < attempts; i++) {
            moveCars();
            printCars();
            System.out.println();
        }
    }

    private void moveCars() {
       for (Car car: cars) {
           car.move();
       }
    }

    private void printCars() {
        for (Car car: cars) {
            System.out.println(car);
        }
    }

}
