package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.Message;
import subway.utils.Validator;
import subway.view.OutputView;

import java.util.Scanner;

public class InputView {
    public static String getMainCmd(Scanner scanner) {
        OutputView.printMain();
        String inputData = scanner.nextLine();
        try {
            Validator.checkMainCommand(inputData);
            return inputData;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getMainCmd(scanner);
        }
    }
}
