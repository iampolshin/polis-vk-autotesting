import org.junit.Assert;
import org.junit.Test;
import pages.AuthorizationPage;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.fail;

public class AuthorizationTest {
    private static final InputStream input = AuthorizationTest.class.getClassLoader()
            .getResourceAsStream("config.properties");
    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final Properties prop = new Properties();

    @Test
    public void testLogin() {
        try {
            prop.load(input);
        } catch (Exception e) {
            fail("Не удалось получить доступ к ресурсам.");
        }
        String login = prop.getProperty("login");
        String pass = prop.getProperty("pass");
        Assert.assertTrue(authorizationPage.login(login, pass)
                .isAuthorized());
    }
}
