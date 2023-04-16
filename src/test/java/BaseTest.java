import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private static final InputStream INPUT = BaseTest.class.getClassLoader()
            .getResourceAsStream("config.properties");
    protected static final Properties PROP = new Properties();

    @BeforeAll
    public static void setUp() {
        try {
            PROP.load(INPUT);
        } catch (Exception e) {
            Assertions.fail("Не удалось получить доступ к ресурсам.");
        }
    }
}
