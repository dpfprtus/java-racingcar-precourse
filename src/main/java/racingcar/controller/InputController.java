package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public List<Car> getCarList() {
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


    public int getTryCount() {

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
