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

    }

    public void initData() {
        initStation();
        initLine();
    }

    public void initStation() {}
    public void initLine() {}
}
