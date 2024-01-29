package racingcar.io;

import java.util.List;

public class CarNameInputHandler extends InputHandler<String[]> {

    private static final String ERROR_NO_NAME = "1대 이상의 이름을 지정해야 합니다";
    private static final String ERROR_EMPTY_NAME = "이름이 비어있을 수 없습니다";
    private static final String ERROR_NAME_TOO_LONG = "차 이름은 5자 이하여야 합니다";

    private static final String NAME_SEPARATOR = ",";

    public CarNameInputHandler() {
        super("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    protected void validate() throws IllegalArgumentException {
        String[] names = prompt.split(NAME_SEPARATOR);

        if (names.length == 0) {
           throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NO_NAME);
        }

        for (String name : names) {
            if (name.length() == 0) {
                throw new IllegalArgumentException(ERROR_PREFIX + ERROR_EMPTY_NAME);
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NAME_TOO_LONG);
            }
        }
    }

    @Override
    public String[] parse() throws IllegalArgumentException {
        validate();
        return prompt.split(NAME_SEPARATOR);
    }
}
