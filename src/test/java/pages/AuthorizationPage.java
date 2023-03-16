package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage extends LoadableComponent<AuthorizationPage> {
    private final static String PAGE_URL = "https://ok.ru/";
    private static final SelenideElement LOGIN_FIELD = $x("//*[@id='field_email']");
    private static final SelenideElement PASS_FIELD = $x("//*[@id='field_password']");
    private static final SelenideElement AUTH_BTN = $x("//div[@class='login-form-actions']/input");

    public AuthorizationPage() {
        load();
    }

    @Override
    protected void load() {
        open(PAGE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        $(LOGIN_FIELD).shouldBe(visible);
        $(PASS_FIELD).shouldBe(visible);
        $(AUTH_BTN).shouldBe(visible);
    }

    public MainPage login(String login, String pass) {
        LOGIN_FIELD.setValue(login);
        PASS_FIELD.setValue(pass);
        AUTH_BTN.click();
        return new MainPage();
    }
}