package subway.utils;

public enum ServiceMenuDetail {
    STATION("1", Message.STATION_DETAIL_MESSAGE),
    LINE("2", Message.LINE_DETAIL_MESSAGE),
    SECTION("3", Message.SECTION_DETAIL_MESSAGE);

    final private String command;
    final private String[] message;

    ServiceMenuDetail(String command, String[] message) {
        this.command = command;
        this.message = message;
    }

    public static String[] findMessageByCommand(String cmd) {
        for (ServiceMenuDetail serviceMenuDetail : ServiceMenuDetail.values()) {
            if (serviceMenuDetail.getCommand().equals(cmd))
                return serviceMenuDetail.getMessage();
        }
        return new String[]{};
    }

    public String getCommand() {
        return command;
    }

    public String[] getMessage() {
        return message;
    }
}
