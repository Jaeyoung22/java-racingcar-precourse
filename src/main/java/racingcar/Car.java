package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String POSITION_INDICATOR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptMove() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position++;
        }
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
