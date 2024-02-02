package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {
    public String[] inputName() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            String car_names = readLine();
            return validateName(car_names);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름을 입력해주세요.");
            return inputName();
        }
    }

    public static String[] validateName(String car_names) {
        String[] input = car_names.split(",");
        for (String i : input) {
            if (i.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 올바른 이름을 입력해주세요.");
            }
            if (i.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }
        return input;
    }

    public static int inputCount() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            String counts = readLine();
            return validateCount(counts);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도할 횟수를 입력해주세요.");
            return inputCount();
        }
    }

    public static int validateCount(String counts) {
        try {
            int c = Integer.parseInt(counts);
            return validateCount(c);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    public static int validateCount(int counts) {
        if (counts <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
        return counts;
    }
}
