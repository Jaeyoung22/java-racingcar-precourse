package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void move() {
        if (judgeNum()) {
            position++;
        }
    }
    // 추가 기능 구현
    public int makeNum() {
        return pickNumberInRange(0, 9);
    }
    public boolean judgeNum() {
        int num = makeNum();
        return num >= 4;
    }
    public void result() {
        System.out.print(name + " : ");
        for (int i = 0; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
