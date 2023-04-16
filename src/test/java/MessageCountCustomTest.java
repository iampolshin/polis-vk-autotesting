import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static matcher.IsPositiveInteger.isAPositiveInteger;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageCountCustomTest extends BaseTest {
    @Test
    public void hasMessagesCustom() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");

        open(AuthorizationPage.PAGE_URL);
        MainPage mainPage = new MainPage(login, password);

        assertThat(mainPage.getMessageCount(), isAPositiveInteger());
    }
}
