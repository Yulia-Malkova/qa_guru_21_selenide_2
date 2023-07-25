package qa_guru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragDropTest {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
    }

    @Test
    void switchByDragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement sourceElement = $("#column-a");
        SelenideElement targetElement = $("#column-b");
        (sourceElement).dragAndDropTo(targetElement);
        targetElement.shouldHave(text("A"));
        sourceElement.shouldHave(text("B"));
    }
}
