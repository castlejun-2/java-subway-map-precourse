package subway.domain;

public enum MainMenu {
    STATION("1","역 관리"),LINE("2","노선 관리"),SECTION("3","구간 관리"),MAP("4","지하철 노선도 출력"),END("Q","종료");

    final private String command;
    final private String message;

    MainMenu(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getCommand() {
        return command;
    }

    public String getMessage() {
        return message;
    }
}
