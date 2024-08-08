package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.IO;

public class GameStarter {

    private final IO io;

    public GameStarter(IO io) {
        this.io = io;
    }

    public void start() {
        List<Car> carList = getCarList();
        int tryCount = io.inputTryCount();
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::generateRandomNumberAndMove);
        }
    }

    private List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        for (String carName : io.inputCarNames()) {
            carList.add(new Car(carName));
        }
        return carList;
    }

}
