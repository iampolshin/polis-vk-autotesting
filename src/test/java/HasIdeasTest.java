import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class HasIdeasTest extends BaseTest {
    @Test
    @DisplayName("Есть ли на странице рекомендация \"Идеи дня\"")
    public void hasIdeas() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");
        String keyWord = "Идеи дня";

        open(AuthorizationPage.PAGE_URL);
        MainPage mainPage = new MainPage(login, password);

        assertThat(mainPage.getIdeas(), equalToIgnoringCase(keyWord));
    }
}
