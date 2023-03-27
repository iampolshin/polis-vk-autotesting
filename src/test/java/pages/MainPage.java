package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends LoadableComponent<MainPage> {
    private static final SelenideElement MAIN_NAV = $x("//div[@id='hook_Block_SideNavigation']");
    private static final SelenideElement SEARCH_BAR = $x("//input[@placeholder='Искать на сайте']");
    private static final SelenideElement MSG_COUNT = $x("//div[@id='counter_ToolbarMessages']/div");
    private static final SelenideElement IDEAS = $x("//*[@class='portlet_h_name_t __multiline']");
    private static final SelenideElement SETTINGS_BTN = $x("//*[@class='ucard-mini_cnt']");
    private static final SelenideElement LOGOUT_LINK = $x(".//*[@class='lp']");
    private static final SelenideElement LOGOUT_BTN = $x(".//*[@class='button-pro form-actions_yes']");

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

    public int getMessageCount() {
        String messageCount = $(MSG_COUNT).text();
        return Integer.parseInt(messageCount.isBlank() ? String.valueOf(0) : messageCount);
    }

    public String getIdeas() {
        return $(IDEAS).text();
    }

    public SearchPage search(String text) {
        $(SEARCH_BAR).setValue(text);
        $(SEARCH_BAR).pressEnter();
        return new SearchPage();
    }

    public void logout() {
        $(SETTINGS_BTN).click();
        $(LOGOUT_LINK).shouldBe(Condition.visible).click();
        $(LOGOUT_BTN).shouldBe(Condition.visible).click();
    }
}
