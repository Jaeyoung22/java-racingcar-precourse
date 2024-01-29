package racingcar;

import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = Game.getInstance();
            game.play();
            game.end();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
        }
    }
}
