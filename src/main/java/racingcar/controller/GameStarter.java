package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.IO;

public class GameStarter {

    private final IO io;

    public GameStarter(IO io) {
        this.io = io;
    }

    public void start() {
        io.printCarNameInputMessage();
        List<Car> carList = getCarList();
        io.printCountInputMessage();
        int tryCount = io.inputTryCount();
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::generateRandomNumberAndMove);
            io.printResultMessage();
            io.printCarPosition(carList);
        }
        Winner winner = new Winner(carList);
        List<String> winnerNames = winner.getWinnerNames();
        io.printWinner(winnerNames);

    }

    private List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        for (String carName : io.inputCarNames()) {
            carList.add(new Car(carName));
        }
        return carList;
    }

}
