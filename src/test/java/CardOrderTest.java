import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    public void shouldTest() {
        $("[data-test-id=name] input").sendKeys("Григорян Ангелина");
        $("[data-test-id=phone] input").sendKeys("+79250881558");
        $("[data-test-id=agreement]").click();
        $("button").click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = $("[data-test-id=order-success]").getText().trim();
        assertEquals(expected, actual);
    }
}