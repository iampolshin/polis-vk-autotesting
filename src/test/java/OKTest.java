import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.SearchPage;

import java.io.InputStream;
import java.util.Properties;

import static matcher.IsPositiveInteger.isAPositiveInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.fail;

public class OKTest {
    private static final InputStream input = OKTest.class.getClassLoader()
            .getResourceAsStream("config.properties");
    private static final AuthorizationPage AUTHORIZATION_PAGE = new AuthorizationPage();
    private static final MainPage MAIN_PAGE = new MainPage();
    private static final SearchPage SEARCH_PAGE = new SearchPage();
    private static final Properties PROP = new Properties();

    @Before
    public void login() {
        try {
            PROP.load(input);
        } catch (Exception e) {
            fail("Не удалось получить доступ к ресурсам.");
        }
        String login = PROP.getProperty("login");
        String pass = PROP.getProperty("pass");
        Assert.assertTrue(AUTHORIZATION_PAGE.login(login, pass).isAuthorized());
    }

    @After
    public void logout() {
        MAIN_PAGE.logout();
    }

    @Test
    public void hasMessagesCustom() {
        assertThat(MAIN_PAGE.getMessageCount(), isAPositiveInteger());
    }

    @Test
    public void hasMessages() {
        assertThat(MAIN_PAGE.getMessageCount(), greaterThan(0));
    }

    @Test
    @DisplayName("Есть ли на странице рекомендация \"Идеи дня\"")
    public void hasIdeas() {
        String text = "Идеи дня";
        assertThat(MAIN_PAGE.getIdeas(), equalToIgnoringCase(text));
    }

    @Test
    public void canFoundInfoByText() {
        String text = "Одноклассники";
        assertThat(MAIN_PAGE.search(text).getFoundLabel(), containsString("Найдено"));
    }

    @Test
    public void saveTextToHistoryOfSearch() {
        String text = "Одноклассники";
        MAIN_PAGE.search(text);
        SEARCH_PAGE.clearSearchText();
        Assert.assertTrue(SEARCH_PAGE.getTextsFromHistoryOfSearch().contains(text));
    }
}
