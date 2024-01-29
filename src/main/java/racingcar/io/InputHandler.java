package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputHandler<T> {

    protected static final String ERROR_PREFIX = "[ERROR] ";

    protected final String prompt;

    public InputHandler(String prompt) {
        this.prompt = prompt;
    }

    public String ask() {
        System.out.println(prompt);
        return Console.readLine();
    }

    protected abstract void validate() throws IllegalArgumentException;

    public abstract T parse() throws IllegalArgumentException;
}
