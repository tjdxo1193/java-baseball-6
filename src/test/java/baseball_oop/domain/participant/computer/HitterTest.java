package baseball_oop.domain.participant.computer;

import baseball_oop.vo.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitterTest {

    private final int LIMITED_LENGTH = 3;

    @Test
    @DisplayName("메세지 호출시 Answer 객체가 생성된다.")
    void generateAnswer_정상동작() {
        // given
        Computer computer = new Hitter();

        //when

        // then
        assertInstanceOf(Answer.class , computer.generateAnswer());
        assertEquals(LIMITED_LENGTH, computer.generateAnswer().getValues().size());
    }
}