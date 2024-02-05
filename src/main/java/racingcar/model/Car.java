package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public Integer move(Integer distance) {
        position += distance;
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return ((Integer)position).compareTo(o.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car otherCar = (Car) obj;
        return position == otherCar.position && Objects.equals(name, otherCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
