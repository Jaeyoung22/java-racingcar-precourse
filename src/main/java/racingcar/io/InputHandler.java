package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputHandler<T> {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String prompt;

    protected String input;

    public InputHandler(String prompt) {
        this.prompt = prompt;
        this.input = null;
    }

    /**
     * 사용자에게서 유효한 입력값을 받아 파싱된 결과를 반환한다
     * @return 유효성 검사를 통과하고 파싱이 완료된 값
     */
    public T readInput() {
        while (input == null) {
            input = ask();
        }
        return parse(input);
    }

    /**
     * 사용자의 입력을 받고 유효성 검사를 실시한다
     * @return 유효성 검사를 통과하면, 유효한 입력값을 반환하고, 실패하면 null을 반환한다
     */
    private String ask() {
        System.out.println(prompt);
        String rawInput = Console.readLine();
        try {
            validate(rawInput);
            return rawInput;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return null;
        }
    }

    /**
     * 사용자의 입력이 유효한지 검사한다
     * @param input 사용자 입력
     * @throws IllegalArgumentException 사용자 입력이 유효하지 않은 경우
     */
    protected abstract void validate(String input) throws IllegalArgumentException;

    /**
     * 유효한 입력을 파싱하여 원하는 데이터를 추출한다
     * @param input 유효성 검사를 통과한 사용자 입력
     * @return 파싱한 결과값
     */
    protected abstract T parse(String input);
}
