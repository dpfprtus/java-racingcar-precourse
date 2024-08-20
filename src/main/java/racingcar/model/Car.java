package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVING_CONDITION = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void generateRandomNumberAndMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
