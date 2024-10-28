package racingcar.controller;

import java.util.List;
import racingcar.dto.CarLocation;
import racingcar.model.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        RacingGame racingGame = initializeRaceGame();
        outputView.printRaceResultPrefix();
        processRaceHistory(racingGame);
        displayWinners(racingGame);
    }

    private RacingGame initializeRaceGame() {
        List<String> carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();
        return racingGameService.initializeRace(carNames, attempts);
    }

    private void processRaceHistory(RacingGame racingGame) {
        List<List<CarLocation>> raceHistory = racingGameService.runRaceRounds(racingGame);
        raceHistory.forEach(outputView::printRaceProcess);
    }

    private void displayWinners(RacingGame racingGame) {
        List<String> winners = racingGameService.getWinners(racingGame.cars());
        outputView.printWinners(winners);
    }
}
