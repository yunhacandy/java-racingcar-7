package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.service.ValidationService;

public class InputView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        ValidationService.validateCarNames(carNames);
        return carNames;
    }

    public int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return ValidationService.validateAttempts(input);
    }
}