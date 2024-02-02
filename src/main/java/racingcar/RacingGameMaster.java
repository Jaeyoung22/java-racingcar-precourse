package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGameMaster {
    Car[] cars;
    int cnt;

    public RacingGameMaster(Car[] cars) {
        this.cars = cars;
    }
    public void startOneRound(){
        for (Car car : cars) car.tryGo();
    }

    public void printOneRoundResult(){
        for(Car car:cars) {
            car.printStatus();
        }
        System.out.println();
    }

    public void printWinner(){
        ArrayList<String> winners = findWinner();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",",winners));
    }

    private ArrayList<String> findWinner(){
        ArrayList<String> winners = new ArrayList<>();
        int winnerDist=this.findWinnerDist();
        for(Car car: this.cars){
            if(car.getPosition()==winnerDist){
                winners.add(car.getName());
            }
        }
        return winners;
    }


    private int findWinnerDist() {
        return Arrays.stream(this.cars).mapToInt(Car::getPosition).reduce(-1, Math::max);
    }

}
