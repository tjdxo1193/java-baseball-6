package baseball_oop.domain.participant.judgment;

import baseball_oop.vo.Answer;
import baseball_oop.vo.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UmpireTest {

    Answer answer;
    Answer input;

    int strikeCount;
    int ballCount;

    @BeforeEach
    void setUp() {
        /*파라미터 없는 Answer 생성자는 랜덤으로 List를 가지지만
         랜덤값에 대한 검증은 하지 않아도 됨으로 임의의 값이라 가정하고 테스트를 진행한다. */
        answer = new Answer("457");
        input = new Answer("345");

        strikeCount = Answer.countSameElementAndPosition(answer.getValues(), input.getValues());
        ballCount = Answer.countContainElement(answer.getValues(), input.getValues()) -
                Answer.countSameElementAndPosition(answer.getValues(), input.getValues());
    }


    @Test
    @DisplayName("정답과 입력을 받으면 올바른 결과를 리턴한다.")
    void judge_정상동작() {
        //when
        Judgment judgment = new Umpire();
        Result result = judgment.judge(answer, input);

        //then
        assertEquals(ballCount, result.getBallCount());
        assertEquals(strikeCount, result.getStrikeCount());
    }

    @Test
    @DisplayName("입력이 NULL 인경우 예외를 발생시킨다.")
    void judge_NPE발생() {
        //when
        Judgment judgment = new Umpire();

        //then
        assertThrows(NullPointerException.class, () -> judgment.judge(answer, null));
    }

}