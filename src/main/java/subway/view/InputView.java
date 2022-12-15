package subway.domain;

import subway.utils.Validator;

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
