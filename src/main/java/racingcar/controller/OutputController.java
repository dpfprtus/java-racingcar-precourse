package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printCarNameInputMessage() {
        outputView.printCarNameInputMessage();
    }

    public void printCountInputMessage() {
        outputView.printCountInputMessage();
    }

    public void printWinner(List<String> winnerNames) {
        outputView.printWinner(winnerNames);
    }

    public void printResult(List<Car> carList) {
        outputView.printResultMessage();
        outputView.printCarPosition(carList);
    }
}
