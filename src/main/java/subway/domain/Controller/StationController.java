package subway.domain.Controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {
    private static String command;
    private static StationRepository stationRepository;
    private static LineRepository lineRepository;

    public StationController(String command, StationRepository stationRepository, LineRepository lineRepository) {
        this.command = command;
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public static void play(Scanner scanner) {
        if (command.equals("1"))
            registerStation(scanner);
        else if (command.equals("2"))
            deleteStation(scanner);
        else if (command.equals("3"))
            getStationList();
    }

    public static void registerStation(Scanner scanner) {
        String input = InputView.getStation(scanner, stationRepository);
        stationRepository.addStation(new Station(input));
    }

    public static void getStationList() {
        OutputView.printStationsInfo(stationRepository);
    }

    public static void deleteStation(Scanner scanner) {
        String input = InputView.getDelStation(scanner, stationRepository, lineRepository);
        stationRepository.deleteStation(input);
    }

    public static StationRepository getNewStationRepository() {
        return stationRepository;
    }
}
