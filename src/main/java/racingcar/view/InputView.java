package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> inputCarNames() {
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int inputTryCount() {
        //숫자가 아닐 시 예외를 발생한다.
        int tryCount;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 횟수는 숫자이어야 합니다.");
        }
        return tryCount;
    }
}
