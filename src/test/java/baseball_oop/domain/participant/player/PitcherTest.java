package baseball_oop.domain.participant.player;

import baseball_oop.vo.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class PitcherTest {
    private final int LIMITED_LENGTH = 3;

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    @DisplayName("메세지 호출시 Answer 객체가 생성된다.")
    void generateAnswer_정상동작() {
        // given
        Player player = new Pitcher();
        InputStream readLine = setReadLine("926");
        System.setIn(readLine);
        Answer input = player.generateAnswer();
        //when

        // then
        assertInstanceOf(Answer.class, input);
        assertEquals(LIMITED_LENGTH, input.getValues().size());
    }
}