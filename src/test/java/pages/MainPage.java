package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends LoadableComponent<MainPage> {
    private static final SelenideElement MAIN_NAV = $x("//div[@id='hook_Block_SideNavigation']");

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        $(MAIN_NAV).shouldBe(Condition.visible);
    }

    public boolean isAuthorized() {
        return $(MAIN_NAV).has(Condition.visible);
    }
}
