package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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
        forward(getTryCount(), carList);
        Winner winner = new Winner(carList);
        io.printWinner(winner.getWinnerNames());
    }


    private void forward(int tryCount, List<Car> carList) {
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::generateRandomNumberAndMove);
            io.printResultMessage();
            io.printCarPosition(carList);
        }
    }

    private List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        for (String carName : io.inputCarNames()) {
            carList.add(new Car(carName));
        }
        try {
            carListValidation(carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.getCarList();
        }
        return carList;
    }

    private void carListValidation(List<Car> carList) {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 차량이 존재하지 않습니다.");
        }
        if (carList.size() != carList.stream().map(Car::getName).distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 차량이름이 존재합니다.");
        }
    }


    private int getTryCount() {
        int tryCount = 0;
        try {
            tryCount = io.inputTryCount();
            tryCountValidate(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.getTryCount();
        }
        return tryCount;
    }

    private void tryCountValidate(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }

}
