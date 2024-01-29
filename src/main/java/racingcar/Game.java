package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class Game {

    private final Cars cars;
    private final int number;

    private boolean ongoing;

    public Game(Cars cars, int number) {
        this.cars = cars;
        this.number = number;
    }

    public static Game getInstance() {
        String names = InputView.readNames();
        Cars cars = CarsMaker.make(names);

        int number = InputView.readNumber();

        return new Game(cars, number);
    }

    public void play() {
        if (ongoing) {
            throw new IllegalStateException("게임이 실행중입니다.");
        }

        ongoing = true;

        for (int i = 0; i < number; i++) {
            cars.race();
            Map<String, Integer> currentPositions = cars.fetchCurrentPositions();
            OutputView.printCurrentPositions(currentPositions);
        }
    }

    public void end() {
        if (!ongoing) {
            throw new IllegalStateException("게임이 실행되지 않았습니다.");
        }

        ongoing = false;

        List<String> winners = cars.fetchWinners();
        OutputView.printWinner(winners);
    }
}
