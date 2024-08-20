package racingcar;

import racingcar.controller.GameStarter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        GameStarter gameStarter = new GameStarter(new InputView(),new OutputView());
        gameStarter.start();
    }
}
