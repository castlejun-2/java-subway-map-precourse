package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.utils.Validator;
import subway.view.OutputView;

import java.util.Scanner;

public class InputView {
    public static String getMainCmd(Scanner scanner) {
        OutputView.printMain();
        OutputView.println(Message.SELECT_FUNCTION_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkMainCommand(inputData);
            return inputData;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getMainCmd(scanner);
        }
    }

    public static String getDetailCmd(String input, Scanner scanner) {
        OutputView.printServiceMenu(input);
        OutputView.println(Message.SELECT_FUNCTION_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkDetailCommand(input, inputData);
            return inputData;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getDetailCmd(input, scanner);
        }
    }

    public static boolean getStation(Scanner scanner, StationRepository stationRepository) {
        OutputView.println(Message.STATION_INPUT_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkStationExist(inputData, stationRepository);
            stationRepository.addStation(new Station(inputData));
            OutputView.println(Message.STATION_ADD_SUCCESS_MESSAGE);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getStation(scanner, stationRepository);
        }
    }

    public static String getDelStation(Scanner scanner, StationRepository stationRepository, LineRepository lineRepository) {
        OutputView.println(Message.DELETE_STATION_INPUT_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkStationExistLine(inputData, stationRepository, lineRepository);
            OutputView.println(Message.STATION_DELETE_SUCCESS_MESSAGE);
            return inputData;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getDelStation(scanner, stationRepository, lineRepository);
        }
    }
}
