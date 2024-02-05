package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("최종 우승자 출력")
    void readme() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD,
                STOP,
                MOVING_FORWARD,

                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD,

                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD,

                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD,

                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("전진 정지")
    void moveOrStop() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("예외처리: 5글자 이상의 이름")
    void nameTooLong() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
