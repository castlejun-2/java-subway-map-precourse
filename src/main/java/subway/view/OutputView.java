package subway.view;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.MainMenu;
import subway.utils.ServiceMenu;
import subway.utils.ServiceMenuDetail;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printMain() {
        println("메인 화면");
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.println(mainMenu.getCommand()+". "+mainMenu.getMessage());
        }
        System.out.println("");
    }

    public static void println(String msg) {
        System.out.println("## "+msg);
    }

    public static void printLineInfo(String LineName, List<Station> stations) {
        printInfo(LineName);
        System.out.println("---");

        for (int i = 0; i < stations.size(); i++)
            printInfo(stations.get(i).getName());
        System.out.println("");
    }

    public static void printStationsInfo(StationRepository stationRepository) {
        for (Station station : stationRepository.stations())
            printInfo(station.getName());
        System.out.println("");
    }

    public static void printError(String errorMsg) {
        System.out.println("[ERROR] "+errorMsg);
    }

    public static void printServiceMenu(String input) {
        println(ServiceMenu.findMessageByCommand(input)+" 화면");
        printServiceMenuDetail(ServiceMenuDetail.findMessageByCommand(input));
    }

    public static void printServiceMenuDetail(String[] msg) {
        for (int i = 0; i < msg.length; i++)
            System.out.println(msg[i]);
        System.out.println("");
    }

    public static void printInfo(String msg) {
        System.out.println("[INFO] "+msg);
    }
}
