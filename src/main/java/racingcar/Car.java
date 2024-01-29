package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String POSITION_INDICATOR = "-";

    private final String name;
    private int position = 0;
    private boolean isWinner = false;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void attemptMove() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name);
        s.append(" : ");
        for (int i = 0; i < position; i++) {
            s.append(POSITION_INDICATOR);
        }
        return s.toString();
    }
}
