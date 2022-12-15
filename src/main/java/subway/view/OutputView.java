package subway.view;

import subway.domain.Station;
import subway.utils.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printMain() {
        print("메인 화면");
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.println(mainMenu.getCommand()+". "+mainMenu.getMessage());
        }
        System.out.println("");
    }

    public static void print(String msg) {
        System.out.println("## "+msg);
    }

    public static void printLineInfo(String LineName, List<Station> stations) {
        System.out.println("[INFO] "+LineName);
        System.out.println("---");
        List<String> station = new ArrayList<>();
        for (int i = 0; i < stations.size(); i++)
            System.out.println("[INFO] "+stations.get(i).getName());
        System.out.println("");
    }

    public static void printError(String errorMsg) {
        System.out.println("[ERROR] "+errorMsg);
    }
}
