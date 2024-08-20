package racingcar.model;

import java.util.List;

public class CarNameValidator implements Validator {

    private final List<Car> carList;

    public CarNameValidator(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public void validate() {
        checkCarNameInCarList();
        checkDuplicateCarName();
    }

    public void checkCarNameInCarList() {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 차량이 존재하지 않습니다.");
        }

    }

    private void checkDuplicateCarName() {
        if (carList.size() != carList.stream().map(Car::getName).distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 차량이름이 존재합니다.");
        }
    }
}
