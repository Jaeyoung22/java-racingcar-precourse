package racingcar.view;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String BLANK = " ";

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR_PREFIX + BLANK + e.getMessage());
    }
}
