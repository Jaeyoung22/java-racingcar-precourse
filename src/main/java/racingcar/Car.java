package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void printStatus(){
        System.out.print(this.name+" : ");
        for (int i=0;i<this.position;i++) System.out.print("-");
        System.out.println();
    }

    public void tryGo(){
        if(canGo()) increasePosition();
    }

    private void increasePosition(){
        this.position++;
    }
    private boolean canGo() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
