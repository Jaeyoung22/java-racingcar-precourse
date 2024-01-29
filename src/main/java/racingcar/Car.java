package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String POSITION_INDICATOR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int distance) {
        position += distance;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name + " : ");
        for (int i = 0; i < position; i++) {
            s.append(POSITION_INDICATOR);
        }
        return s.toString();
    }
}
