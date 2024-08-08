package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<Car> cars;

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("차량이 존재하지 않습니다."));
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName)
                .collect(Collectors.toList());
    }
}
