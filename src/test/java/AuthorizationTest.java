import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import java.io.InputStream;
import java.util.Properties;

import static matcher.IsPositiveInteger.isAPositiveInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.fail;

public class AuthorizationTest {
    private static final InputStream input = AuthorizationTest.class.getClassLoader()
            .getResourceAsStream("config.properties");
    private static final AuthorizationPage AUTHORIZATION_PAGE = new AuthorizationPage();
    private static final MainPage MAIN_PAGE = new MainPage();
    private static final Properties PROP = new Properties();

    @Before
    public void testLogin() {
        try {
            PROP.load(input);
        } catch (Exception e) {
            fail("Не удалось получить доступ к ресурсам.");
        }
        String login = PROP.getProperty("login");
        String pass = PROP.getProperty("pass");
        Assert.assertTrue(AUTHORIZATION_PAGE.login(login, pass).isAuthorized());
    }

    @Test
    public void hasMessages() {
        assertThat(MAIN_PAGE.getMessageCount(), isAPositiveInteger());
    }

    // Проверяет, есть ли на странице рекомендация "Идеи дня"
    @Test
    public void hasIdeas() {
        String text = "Идеи дня";
        assertThat(MAIN_PAGE.getIdeas(), equalToIgnoringCase(text));
    }
}
