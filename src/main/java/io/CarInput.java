package io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

public class CarInput {
    public static Car[] inputCars() {
        while (true) {
            System.out.print("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) : ");
            String[] carNames = Console.readLine().split(",");
            if (!validateCarInput(carNames)) continue;

            Car[] cars = new Car[carNames.length];
            for (int i = 0; i < cars.length; i++)
                cars[i] = new Car(carNames[i]);

            return cars;
        }
    }

    public static int inputCnt(){
        while (true) {
            System.out.print("시도할 회수 : ");
            String cnt = Console.readLine();
            if (!validateCountInput(cnt)) continue;

            return Integer.parseInt(cnt);
        }
    }


    private static boolean validateCarInput(String[] carsInput){
        try{
            for (String carName : carsInput) {
                if (carName.length() > 5)
                    throw new IllegalArgumentException("[ERROR] 잘못된 Name 입력입니다.");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean validateCountInput(String cntInput) {
        try{
            if(!cntInput.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException("[ERROR] 잘못된 Count 입력입니다.");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
