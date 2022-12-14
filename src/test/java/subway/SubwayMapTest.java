package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.domain.SubwayMap;


import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class SubwayMapTest {
    @Test
    @DisplayName("게임이 Q 입력시 종료되는지 확인하는 테스트")
    void checkGameOver() {
        assertThat(new SubwayMap(new Scanner(System.in)).isQuit("Q")).isEqualTo(true);
        assertThat(new SubwayMap(new Scanner(System.in)).isQuit("T")).isEqualTo(false);
    }
}
