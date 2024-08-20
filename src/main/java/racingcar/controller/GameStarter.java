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

    private final InputController inputController;
    private final OutputController outputController;
    public GameStarter(InputView inputView,OutputView outputView) {
        this.outputController = new OutputController(outputView);
        this.inputController = new InputController(inputView);
    }

    public void start() {
        outputController.printCarNameInputMessage();
        List<Car> carList = inputController.getCarList();
        outputController.printCountInputMessage();
        forward(inputController.getTryCount(), carList);
        Winner winner = new Winner(carList);
        outputController.printWinner(winner.getWinnerNames());
    }


    private void forward(int tryCount, List<Car> carList) {
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::generateRandomNumberAndMove);
            outputController.printResult(carList);
        }
    }







}
