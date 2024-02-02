package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        Game game = Game.startGame(); //static이므로 바로 함수 호출 가능.
        game.play();
    }
}
