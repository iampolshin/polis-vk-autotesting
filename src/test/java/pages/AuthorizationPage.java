package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AuthorizationPage extends LoadableComponent<AuthorizationPage> {
    private static final SelenideElement LOGIN_FIELD = $x("//*[@id='field_email']");
    private static final SelenideElement PASS_FIELD = $x("//*[@id='field_password']");
    private static final SelenideElement AUTH_BTN = $x("//div[@class='login-form-actions']/input");
    private static final Condition VISIBLE_CONDITION = visible.because("Нет элемента");
    public static final String PAGE_URL = "https://ok.ru/";

    public AuthorizationPage() {
        isLoaded();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        if (!url().equals(PAGE_URL)) {
            throw new IllegalStateException("Загружена неправильная страница");
        }

        $(LOGIN_FIELD).shouldBe(VISIBLE_CONDITION);
        $(PASS_FIELD).shouldBe(VISIBLE_CONDITION);
        $(AUTH_BTN).shouldBe(VISIBLE_CONDITION);
    }

    public boolean isPresent() {
        return $(LOGIN_FIELD).has(VISIBLE_CONDITION);
    }

    public MainPage login(String login, String password) {
        $(LOGIN_FIELD).shouldBe(VISIBLE_CONDITION).setValue(login);
        $(PASS_FIELD).shouldBe(VISIBLE_CONDITION).setValue(password);
        $(AUTH_BTN).shouldBe(VISIBLE_CONDITION).click();
        return new MainPage();
    }
}
