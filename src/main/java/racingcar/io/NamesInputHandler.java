package racingcar.io;

public class NamesInputHandler extends InputHandler<String[]> {
    private static final String ERROR_NO_NAMES = "차 이름을 1개 이상 입력해야 합니다";
    private static final String ERROR_NAME_EMPTY = "차 이름은 비어있을 수 없습니다";
    private static final String ERROR_NAME_TOO_LONG = "차 이름을 5글자 이하로 입력해주세요";

    public NamesInputHandler() {
        super("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    protected void validate(String input) throws IllegalArgumentException {
        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException(ERROR_NO_NAMES);
        }
        for (String name: names) {
            if (name.length() == 0) {
                throw new IllegalArgumentException(ERROR_NAME_EMPTY);
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
            }
        }
    }

    @Override
    protected String[] parse(String input) {
        return input.split(",");
    }
}
