import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MessagePage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class CorrespondenceListTest extends BaseTest {
    @Test
    public void hasListOfPeopleWithWhomThereIsCorrespondence() {
        String login = PROP.getProperty("login");
        String password = PROP.getProperty("password");

        open(AuthorizationPage.PAGE_URL);
        MessagePage messagePage = new MessagePage(login, password);

        assertThat(messagePage.getListOfPeopleWithWhomThereIsCorrespondence().size(), greaterThan(0));
    }
}
