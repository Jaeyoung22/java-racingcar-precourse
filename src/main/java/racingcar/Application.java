package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.CarMaker;

public class Application {
    public static void main(String[] args) {
        List<Car> cars;
        Integer trialCount;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            String[] carNames = Console.readLine().trim().split(",");
            try {
                cars = CarMaker.makeCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            try {
                trialCount = getTrialCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        System.out.println("\n실행 결과");
        List<Car> winners = Game.start(cars, trialCount);
        List<String> winnerNames = winners.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(",", winnerNames));
        
        
    }

    private static Integer getTrialCount() {
        String trialCountStr = Console.readLine().trim();
        try {
            return Integer.parseInt(trialCountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 한다.");
        }
    }
}
