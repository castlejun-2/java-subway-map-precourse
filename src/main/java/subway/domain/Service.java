package subway.domain;

import subway.domain.Controller.StationController;
import subway.utils.ServiceMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Service {
    public static LineRepository lineRepository;
    public static StationRepository stationRepository;

    public Service(LineRepository lineRepository, StationRepository stationRepository){
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public LineRepository lineRepository() { return lineRepository; }
    public StationRepository stationRepository() { return stationRepository; }

    public static void play(Scanner scanner, String input) {
        String inputData = InputView.getDetailCmd(input, scanner);
        if (inputData.equals("B"))
            return;
        selectService(scanner, input, inputData);
    }

    public static void selectService(Scanner scanner, String input, String inputDetail) {
        if (input.equals("1")) {
            StationController stationController = new StationController(inputDetail, stationRepository,lineRepository);
            stationController.play(scanner);
            stationRepository = stationController.getNewStationRepository();
        }
        //else if (input.equals("2"))
        //    new LineController(inputDetail,lineRepository).play();
        //else if (input.equals("3"))
        //    new SectionController(inputDetail,stationRepository,lineRepository).play();
    }
}
