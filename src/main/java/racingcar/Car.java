package racingcar;

public class Car {

    private static final int THRESHOLD = 4;

    private final String name;

    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void moveIfPowerEnough(int power) {
        if (power >= THRESHOLD) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
