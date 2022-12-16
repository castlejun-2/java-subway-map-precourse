package subway.domain.Controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private static String command;
    private static LineRepository lineRepository;

    public LineController(String input, LineRepository lineRepository) {
        this.command = input;
        this.lineRepository = lineRepository;
    }

    public static void play(Scanner scanner) {
        if (command.equals("1"))
            registerLine(scanner);
        else if (command.equals("2"))
            deleteLine(scanner);
        else if (command.equals("3"))
            getLineList();
    }

    public static void registerLine(Scanner scanner) {
        Line inputLine = InputView.getLine(scanner, lineRepository);
        lineRepository.addLine(inputLine);
    }

    public static void deleteLine(Scanner scanner) {
        String input = InputView.getDelLine(scanner, lineRepository);
        lineRepository.deleteLineByName(input);
    }

    public static void getLineList() {
        OutputView.printLinesInfo(lineRepository);
    }
}
