package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.TryCountValidator;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameStarter {

    private final InputView inputView;
    private final OutputView outputView;

    public GameStarter(InputView inputView,OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printCarNameInputMessage();
        List<Car> carList = getCarList();
        outputView.printCountInputMessage();
        forward(getTryCount(), carList);
        Winner winner = new Winner(carList);
        outputView.printWinner(winner.getWinnerNames());
    }


    private void forward(int tryCount, List<Car> carList) {
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::generateRandomNumberAndMove);
            outputView.printResultMessage();
            outputView.printCarPosition(carList);
        }
    }

    private List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        CarNameValidator carNameValidator = new CarNameValidator(carList);
        for (String carName : inputView.inputCarNames()) {
            carList.add(new Car(carName));
        }
        try {
            carNameValidator.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.getCarList();
        }
        return carList;
    }


    private int getTryCount() {

        int tryCount = 0;
        try {
            tryCount = inputView.inputTryCount();
            TryCountValidator tryCountValidator = new TryCountValidator(tryCount);
            tryCountValidator.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.getTryCount();
        }
        return tryCount;
    }



}
