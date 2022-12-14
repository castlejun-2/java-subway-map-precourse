package subway.domain;

public class OutputView {
    public static void printArray(String[] msg) {
        for (int i = 0; i < msg.length; i++ )
            System.out.println(msg[i]);
        System.out.println("");
    }

    public static void printError(String errorMsg) {
        System.out.println("[ERROR] "+errorMsg);
    }
}
