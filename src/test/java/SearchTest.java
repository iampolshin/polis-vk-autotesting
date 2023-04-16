import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SearchTest extends BaseTest {
    @Test
    public void canFoundInfoByText() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");
        String keyWord = "Одноклассники";

        open(AuthorizationPage.PAGE_URL);
        MainPage mainPage = new MainPage(login, password);

        assertThat(mainPage.search(keyWord).getFoundLabel(), containsString("Найдено"));
    }
}
