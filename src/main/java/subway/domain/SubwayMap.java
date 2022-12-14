package subway.domain;

import java.util.Scanner;

public class SubwayMap {
    private Scanner scanner;
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public SubwayMap(Scanner scanner){
        this.scanner = scanner;
        initData();
    }

    public void play() {
        while (true) {
            OutputView.printArray(Message.MAIN_MESSAGE);
            String inputData = InputView.getMainCmd(scanner);
        }
    }

    public void initData() {
        initStation();
        initLine();
    }

    public void initStation() {
        String stations[] = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String station : stations)
            stationRepository.addStation(new Station(station));
    }
    public void initLine() {
        String lines[] = {"2호선", "3호선", "신분당선"};
        for (String line : lines)
            lineRepository.addLine(new Line(line));
    }
}
