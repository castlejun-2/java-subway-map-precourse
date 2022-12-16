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

    public static String getStation(Scanner scanner, StationRepository stationRepository) {
        OutputView.println(Message.STATION_INPUT_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkStationExist(inputData, stationRepository);
            OutputView.println(Message.STATION_ADD_SUCCESS_MESSAGE);
            return inputData;
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

    public static String getDelLine(Scanner scanner, LineRepository lineRepository) {
        OutputView.println(Message.DELETE_LINE_INPUT_MESSAGE);
        String inputData = scanner.nextLine();
        try {
            Validator.checkExistLine(inputData, lineRepository);
            OutputView.println(Message.LINE_DELETE_SUCCESS_MESSAGE);
            return inputData;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getDelLine(scanner, lineRepository);
        }
    }

    public static Line getLine(Scanner scanner, LineRepository lineRepository) {
        OutputView.println(Message.ADD_LINE_INPUT_MESSAGE);
        try {
            String inputLineName = scanner.nextLine();
            Validator.checkLineExist(inputLineName, lineRepository);
            Line line = new Line(inputLineName);

            OutputView.println(Message.ADD_LINE_TOP_STATION_INPUT_MESSAGE);
            String inputTopStation = scanner.nextLine();
            line.addStationByIndex(new Station(inputTopStation),0);

            OutputView.println(Message.ADD_LINE_BOTTOM_STATION_INPUT_MESSAGE);
            String inputBottomStation = scanner.nextLine();
            line.addStationByIndex(new Station(inputBottomStation),0);

            OutputView.println(Message.LINE_ADD_SUCCESS_MESSAGE);
            System.out.println("");
            return line;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getLine(scanner, lineRepository);
        }
    }
}
