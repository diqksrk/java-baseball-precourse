package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("바로 게임 종료")
    void game_end() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("게임 2회 진행 후 재시작 - case1")
    void game_second_restart1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "179", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 1, 7, 9
        );
    }

    @Test
    @DisplayName("게임 2회 진행 후 재시작 - case2")
    void game_second_restart2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "123", "179" , "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 1, 7, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 실행 중 예외 테스트")
    void game_ing_exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123", "1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
