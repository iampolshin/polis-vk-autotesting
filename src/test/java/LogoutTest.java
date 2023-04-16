import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {
    @Test
    public void logout() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");

        open(AuthorizationPage.PAGE_URL);
        MainPage mainPage = new MainPage(login, password);

        assertTrue(mainPage.logout().isPresent());
    }
}
