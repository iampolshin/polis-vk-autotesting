package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
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
    private static final SelenideElement MESSAGES_BTN = $x("//*[@class='toolbar_nav_i' and @data-l='t,messages']");
    private static final Condition VISIBLE_CONDITION = visible.because("Нет элемента");

    public MainPage() {
        isLoaded();
    }

    public MainPage(String login, String password) {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.login(login, password);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        $(MAIN_NAV).shouldBe(VISIBLE_CONDITION);
    }

    public boolean isAuthorized() {
        return $(MAIN_NAV).has(VISIBLE_CONDITION);
    }

    public int getMessageCount() {
        String messageCount = $(MSG_COUNT).shouldBe(VISIBLE_CONDITION).text();
        return Integer.parseInt(messageCount.isBlank() ? String.valueOf(0) : messageCount);
    }

    public String getIdeas() {
        return $(IDEAS).shouldBe(VISIBLE_CONDITION).text();
    }

    public SearchPage search(String text) {
        $(SEARCH_BAR).shouldBe(VISIBLE_CONDITION).setValue(text);
        $(SEARCH_BAR).shouldBe(VISIBLE_CONDITION).pressEnter();
        return new SearchPage();
    }

    public AuthorizationPage logout() {
        $(SETTINGS_BTN).shouldBe(VISIBLE_CONDITION).click();
        $(LOGOUT_LINK).shouldBe(VISIBLE_CONDITION).click();
        $(LOGOUT_BTN).shouldBe(VISIBLE_CONDITION).click();
        return new AuthorizationPage();
    }

    public void clickMessageBtn() {
        $(MESSAGES_BTN).shouldBe(VISIBLE_CONDITION).click();
    }
}
