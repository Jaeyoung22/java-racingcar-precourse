package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import racingcar.io.InputHandler;

public class Game {

    public static Game startGame() {
        InputHandler inputHandler = new InputHandler();
        String[] car_names = inputHandler.inputName();
        int counts = inputHandler.inputCount();
        return new Game(car_names, counts); //return으로 바로 생성자 실행
    }

    final ArrayList<Car> cars = new ArrayList<>();
    final int counts;
    private Game(String[] car_names, int counts) { //여기서만 사용할거니까 private
        for (String c : car_names) {
            cars.add(new Car(c));
        }
        this.counts = counts;
    }

    public void play() {
        System.out.println("실행 결과");
        for (int i=0; i < counts; i++) {
            for (Car c : cars) {
                c.move();
                c.result();
            }
            System.out.println();
        }
        Rank.findWinner(cars);
        Rank.printWinner();
    }
}
