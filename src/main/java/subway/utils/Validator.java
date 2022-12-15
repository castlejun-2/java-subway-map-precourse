package subway.utils;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.MainMenu;
import subway.utils.Message;

import java.util.List;

public class Validator {
    public static void checkMainCommand(String inputData) {
        boolean flag = false;
        for (MainMenu mainMenu : MainMenu.values()) {
            if (mainMenu.getCommand().equals(inputData)) {
                flag = true;
                break;
            }
        }
        if (!flag)
            throw new IllegalArgumentException(Message.COMMAND_ERROR);
    }
}
