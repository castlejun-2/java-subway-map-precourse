package subway.utils;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
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

    public static boolean checkDetailCommand(String input, String inputData) {
        if (inputData.equals("B"))  //알파벳 B이면 정상 반환
            return true;
        for (Character c : inputData.toCharArray()) {   //B가 아닌 알파벳이 들어가 있는 경우 에러 반환
            if (Character.isAlphabetic(c))
                throw new IllegalArgumentException(Message.COMMAND_ERROR);
        }
        //숫자가 주어진 명령어의 갯수보다 많은 경우 에러 반환
        int cmdLength = ServiceMenuDetail.findMessageByCommand(input).length;

        if (cmdLength <= Integer.parseInt(inputData) || cmdLength == 0)
            throw new IllegalArgumentException(Message.COMMAND_ERROR);
        return true;
    }

    public static void checkStationExist(String input, StationRepository stationRepository) {
        for (Station station : stationRepository.stations()) {
            if (station.getName().equals(input))
                throw new IllegalArgumentException(Message.STATION_IS_EXIST);
        }
    }

    public static void checkStationExistLine(String input,StationRepository stationRepository, LineRepository lineRepository) {
        for (Line line : lineRepository.lines()) {
            for (Station station : line.stations()) {
                if (station.getName().equals(input))
                    throw new IllegalArgumentException(Message.EXIST_STATION_IS_NOT_DELETE);
            }
        }
        boolean flag = true;
        for (Station station : stationRepository.stations()) {
            if (station.getName().equals(input)) {
                flag = false;
                break;
            }
        }
        if (flag)
            throw new IllegalArgumentException(Message.STATION_IS_NOT_EXIST);
    }
}
