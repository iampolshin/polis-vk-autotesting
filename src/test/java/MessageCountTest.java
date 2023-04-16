import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class MessageCountTest extends BaseTest {
    @Test
    public void hasMessages() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");

        open(AuthorizationPage.PAGE_URL);
        MainPage mainPage = new MainPage(login, password);

        assertThat(mainPage.getMessageCount(), greaterThan(0));
    }
}
