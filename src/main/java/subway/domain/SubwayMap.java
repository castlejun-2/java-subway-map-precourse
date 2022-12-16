package subway.domain;

import subway.view.InputView;

import java.util.*;

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
            String inputData = InputView.getMainCmd(scanner);
            if (isQuit(inputData))
                break;
            if (inputData.equals("4")) {
                printLineInfo(lineRepository);
                continue;
            }
            Service service = new Service(lineRepository, stationRepository);
            syncData(service);
            service.play(scanner, inputData);
        }
    }

    public void syncData(Service service) {
        lineRepository = service.lineRepository();
        stationRepository = service.stationRepository();
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
        int index = 0;
        Station[][] stations = new Station[][]{{new Station("교대역"), new Station("강남역"), new Station("역삼역")},
                {new Station("교대역"), new Station("남부터미널역"), new Station("양재역"), new Station("매봉역")},
                {new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역")}};
        for (String line : lines) {
            Line line1 = new Line(line);
            line1.addStation(stations[index++]);
            lineRepository.addLine(line1);
        }
    }

    public boolean isQuit(String inputData) {
        if (inputData.equals("Q"))
            return true;
        return false;
    }

    public void printLineInfo(LineRepository lineRepository) {
        for (int i = 0; i < lineRepository.lines().size(); i++)
            lineRepository.lines().get(i).getLineInfo();
    }
}
