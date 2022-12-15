package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station[] station) {
        stations.addAll(List.of(station));
    }

    public void addStationByIndex(Station station, int index) {
        stations.add(index,station);
    }
}
