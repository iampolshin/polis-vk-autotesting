import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        String login = PROP.getProperty("login");
        String pass = PROP.getProperty("password");

        open(AuthorizationPage.PAGE_URL);
        AuthorizationPage authorizationPage = new AuthorizationPage();

        assertTrue(authorizationPage.login(login, pass).isAuthorized());
    }
}
