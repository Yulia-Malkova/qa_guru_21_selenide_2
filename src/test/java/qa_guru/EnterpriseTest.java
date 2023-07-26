package qa_guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
    }
    @Test
    void enterprisePageOpensFromSolutions() {
    open("https://github.com/");
    $(".header-menu-wrapper").$(byText("Solutions")).hover();
    $(byText("Enterprise")).click();
    $(".application-main .h1-mktg").shouldHave(text("Build like the best"));
    }
}
