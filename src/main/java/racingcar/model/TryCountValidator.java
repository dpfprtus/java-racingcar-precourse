package racingcar.model;

public class TryCountValidator implements Validator {

    private final int tryCount;

    public TryCountValidator(int tryCount) {
        this.tryCount = tryCount;
    }

    @Override
    public void validate() {
        checkMoreThanOne();
    }

    private void checkMoreThanOne() {
        if (tryCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
