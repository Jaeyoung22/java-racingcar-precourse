package racingcar;

import io.CarInput;

public class RacingGame {
    public void startRacing(){
        Car[] cars = CarInput.inputCars();
        int cnt = CarInput.inputCnt();

        RacingGameMaster gameMaster = new RacingGameMaster(cars);
        for(int i=0;i<cnt;i++) {
            gameMaster.startOneRound();
            gameMaster.printOneRoundResult();
        }

        gameMaster.printWinner();
    }

}
