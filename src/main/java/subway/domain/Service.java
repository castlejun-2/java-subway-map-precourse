package subway.domain;

import subway.utils.ServiceMenu;
import subway.view.OutputView;

public class Service {

    public Service(String input) {
        OutputView.printServiceMenu(input);
    }
}
