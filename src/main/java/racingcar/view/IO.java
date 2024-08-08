package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class IO {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInputMessage() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public void printWinner(List<String> winners) {
        String.join(",", winners);
    }

    public List<String> inputCarNames() {
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int inputTryCount(){
        return Integer.parseInt(Console.readLine());
    }



}
