package racingcar.io;

public class AttemptsInputHandler extends InputHandler<Integer> {
    private static final String ERROR_NAN = "시도 횟수는 숫자여야 합니다";
    private static final String ERROR_NEGATIVE = "시도 횟수는 양의 정수여야 합니다";

    public AttemptsInputHandler() {
        super("시도할 횟수는 몇 회인가요?");
    }

    @Override
    protected void validate(String input) throws IllegalArgumentException {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_NAN);
        }

        int inputNum = Integer.parseInt(input);
        if (inputNum <= 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }

    @Override
    protected Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
