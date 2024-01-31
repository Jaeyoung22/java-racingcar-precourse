package racingcar.controller;

import racingcar.model.CarHandler;
import racingcar.view.RacingView;

public class RacingController {
    private final CarHandler carHandler = new CarHandler();

    public void run() {
        try{
            carHandler.addCar(RacingView.inputCarName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            processRacing(validate(RacingView.inputTryNum()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        RacingView.outputWinner(carHandler.getFirstCarName());
    }

    private void processRacing(int tryNum) {
        RacingView.outputProcessStart();
        for (int i = 0; i<tryNum; i++) {
            RacingView.outputProcess(carHandler.moveCar());
        }
    }

    private int validate(String tryNumStr) {
        int tryNum;
        try {
            tryNum = Integer.parseInt(tryNumStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 숫자가 아닙니다.");
        }

        if (tryNum <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 시도 횟수입니다.");
        }
        return tryNum;
    }
}
