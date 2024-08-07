package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class IO {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int inputTryCount(){
        return Integer.parseInt(Console.readLine());
    }


}
