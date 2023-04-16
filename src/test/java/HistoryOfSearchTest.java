import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoryOfSearchTest extends BaseTest {
    @Test
    public void saveTextToHistoryOfSearch() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");
        String keyWord = "Одноклассники";

        open(AuthorizationPage.PAGE_URL);
        SearchPage searchPage = new MainPage(login, password).search(keyWord);
        searchPage.clearSearchText();

        assertTrue(searchPage.getTextsFromHistoryOfSearch().contains(keyWord));
    }
}
