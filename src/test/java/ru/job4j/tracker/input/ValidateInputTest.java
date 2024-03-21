package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputNumbers() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "0", "4", "6", "-2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(0);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(4);
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4).isEqualTo(6);
        int selected5 = input.askInt("Enter menu:");
        assertThat(selected5).isEqualTo(-2);
    }

    @Test
    void whenValidInputMinus3() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-3);

    }
}