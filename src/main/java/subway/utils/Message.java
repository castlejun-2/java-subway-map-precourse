package subway.utils;

public class Message {
    public static final String COMMAND_ERROR = "주어진 명령어만 입력 가능합니다.";

    public static final String SELECT_FUNCTION_MESSAGE = "원하는 기능을 선택하세요.";
    public static final String LINE_INPUT_MESSAGE = "노선을 입력하세요.";
    public static final String STATION_INPUT_MESSAGE = "등록할 역 이름을 입력하세요.";
    public static final String ADD_LINE_INPUT_MESSAGE = "등록할 노선 이름을 입력하세요.";
    public static final String ADD_LINE_TOP_STATION_INPUT_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String ADD_LINE_BOTTOM_STATION_INPUT_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String STATION_ADD_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    public static final String LINE_ADD_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    public static final String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    public static final String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    public static final String EXIST_STATION_IS_NOT_DELETE = "노선에 등록된 역은 삭제할 수 없습니다.";
    public static final String STATION_IS_NOT_EXIST = "존재하지 않는 지하철 역입니다.";
    public static final String DELETE_STATION_INPUT_MESSAGE = "삭제할 역 이름을 입력하세요.";
    public static final String DELETE_LINE_INPUT_MESSAGE = "삭제할 노선 이름을 입력하세요.";

    public static final String[] STATION_DETAIL_MESSAGE = {"1. 역 등록" , "2. 역 삭제", "3. 역 조회", "B. 돌아가기"};
    public static final String[] LINE_DETAIL_MESSAGE = {"1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기"};
    public static final String[] SECTION_DETAIL_MESSAGE = {"1. 구간 등록", "2. 구간 삭제", "B. 돌아가기"};

    public static final String LINE_IS_NOT_EXIST = "존재하지 않는 노선입니다.";
    public static final String STATION_IS_EXIST = "이미 존재하는 역입니다";
    public static final String LINE_IS_EXIST = "이미 존재하는 역입니다";
}
