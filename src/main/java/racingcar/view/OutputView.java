package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String BLANK = " ";

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR_PREFIX + BLANK + e.getMessage());
    }

    public static void printResultNotification() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentPositions(Map<String, Integer> currentPositions) {
        currentPositions.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }
}
