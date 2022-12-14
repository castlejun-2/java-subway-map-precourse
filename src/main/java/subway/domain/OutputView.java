package subway.domain;

public class OutputView {
    public static void printMain() {
        System.out.println("## 메인 화면");
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.println(mainMenu.getCommand()+". "+mainMenu.getMessage());
        }
        System.out.println("");
    }

    public static void printError(String errorMsg) {
        System.out.println("[ERROR] "+errorMsg);
    }
}
