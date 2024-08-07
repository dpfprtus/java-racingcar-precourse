package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.IO;

public class GameStarter {

    private final IO io;
    private final Car car;

    public GameStarter(IO io, Car car) {
        this.car = car;
        this.io = io;
    }

    public void start() {
        List<String> carNames = io.inputCarNames();
        int tryCount = io.inputTryCount();
    }

}
