package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class IO {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInputMessage() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public void printWinner(List<String> winnerList) {
        String winners = String.join(",", winnerList);
        System.out.println("최종 우승자 : "+ winners);
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printCarPosition(List<Car> carList) {

        for (Car car : carList) {
            StringBuilder resultMessage = new StringBuilder(car.getName());
            resultMessage.append(": ");
            for (int i = 0; i < car.getPosition(); i++) {
                resultMessage.append("-");
            }
            System.out.println(resultMessage);
        }
        System.out.println();
    }

    public List<String> inputCarNames() {
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int inputTryCount(){
        return Integer.parseInt(Console.readLine());
    }



}
