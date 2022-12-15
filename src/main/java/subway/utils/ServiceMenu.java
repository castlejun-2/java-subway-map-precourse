package subway.utils;

import java.util.Arrays;

public enum ServiceMenu {
    STATION("1", "역 관리"), LINE("2", "노선 관리"), SECTION("3", "구간 관리"), MAP("4", "지하철 노선도"), END("Q", "종료");

    final private String command;
    final private String message;

    ServiceMenu(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public static String findMessageByCommand(String command) {
        String message = "";
        for (ServiceMenu serviceMenu : ServiceMenu.values()) {
            if (serviceMenu.getCommand().equals(command))
                message = serviceMenu.getMessage();
        }
        return message;
    }

    public String getCommand() {
        return command;
    }

    public String getMessage() {
        return message;
    }
}
