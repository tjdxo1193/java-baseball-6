package baseball_oop.vo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void countSameElementAndPosition_정상동작() {
        // given
        List<Integer> arrAnswer = new ArrayList<>(Arrays.stream(new int[]{1, 2, 3}).boxed().toList());
        List<Integer> arrInput_One = new ArrayList<>(Arrays.stream(new int[]{3, 2, 1}).boxed().toList());
        List<Integer> arrInput_Two = new ArrayList<>(Arrays.stream(new int[]{1, 2, 4}).boxed().toList());
        List<Integer> arrInput_Three = new ArrayList<>(Arrays.stream(new int[]{1, 2, 3}).boxed().toList());
        List<Integer> arrInput_Zero = new ArrayList<>(Arrays.stream(new int[]{3, 4, 1}).boxed().toList());

        // when
        int oneCount = Answer.countSameElementAndPosition(arrAnswer, arrInput_One);
        int twoCount = Answer.countSameElementAndPosition(arrAnswer, arrInput_Two);
        int threeCount = Answer.countSameElementAndPosition(arrAnswer, arrInput_Three);
        int zeroCount = Answer.countSameElementAndPosition(arrAnswer, arrInput_Zero);

        // then
        assertEquals(1, oneCount);
        assertEquals(2, twoCount);
        assertEquals(3, threeCount);
        assertEquals(0, zeroCount);
    }

    @Test
    void countContainElement_정상동작() {
        // given
        List<Integer> arrAnswer = new ArrayList<>(Arrays.stream(new int[]{3, 7, 9}).boxed().toList());
        List<Integer> arrInput_One = new ArrayList<>(Arrays.stream(new int[]{7, 2, 1}).boxed().toList());
        List<Integer> arrInput_Two = new ArrayList<>(Arrays.stream(new int[]{9, 5, 3}).boxed().toList());
        List<Integer> arrInput_Three = new ArrayList<>(Arrays.stream(new int[]{3, 7, 9}).boxed().toList());
        List<Integer> arrInput_Zero = new ArrayList<>(Arrays.stream(new int[]{4, 5, 6}).boxed().toList());

        // when
        int oneCount = Answer.countContainElement(arrAnswer, arrInput_One);
        int twoCount = Answer.countContainElement(arrAnswer, arrInput_Two);
        int threeCount = Answer.countContainElement(arrAnswer, arrInput_Three);
        int zeroCount = Answer.countContainElement(arrAnswer, arrInput_Zero);

        // then
        assertEquals(1, oneCount);
        assertEquals(2, twoCount);
        assertEquals(3, threeCount);
        assertEquals(0, zeroCount);
    }

    @Test
    void 중복값일경우_예외발생O() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Answer("334"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 숫자가아닐경우_예외발생O() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Answer("d45"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 지정길이초과일경우_예외발생O() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Answer("8756"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 지정길이미만일경우_예외발생O() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Answer("86"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복X_숫자O_지정길이인경우_예외발생X() {
        // 값 정상인 경우
        assertSimpleTest(() ->
            assertThatNoException()
                    .isThrownBy(() -> new Answer("785"))
        );
    }

}