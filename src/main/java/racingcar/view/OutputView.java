package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.constant.OutputMessage;

public class OutputView {

    public void printRaceResultPrefix() {
        printNewLine();
        System.out.println(OutputMessage.RESULT_PREFIX);
    }

    public void printRaceProcess(Map<String, Integer> raceResult) {
        raceResult.forEach((name, position) ->
                System.out.println(name + " : " + "-".repeat(position))
        );
        printNewLine();
    }

    public void printWinners(List<String> winners) {
        System.out.println(OutputMessage.WINNERS_ANNOUNCEMENT + String.join(", ", winners));
    }

    private void printNewLine() {
        System.out.println();
    }
}