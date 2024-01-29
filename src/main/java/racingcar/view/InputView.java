package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readNames() {
        try {
            String input = Console.readLine();
            return validate(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            return readNames();
        }
    }

    private static String validate(String input) {
        if (input.contains(",")) {
            return input;
        }

        throw new IllegalArgumentException("이름은 쉼표로 구분되어야 합니다.");
    }
}
