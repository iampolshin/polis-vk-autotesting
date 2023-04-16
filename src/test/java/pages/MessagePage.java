package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MessagePage extends LoadableComponent<MessagePage> {
    private static final SelenideElement CREATE_CHAT_BTN = $x("//*[@data-tsid='open_plus_button']");
    private static final SelenideElement CORRESPONDENCES_LIST_WRAPPER = $x("//*[@data-tsid='conversation_list']");
    private static final ElementsCollection CORRESPONDENCES_LIST = $$x("//*[@data-tsid='conversation_list']/msg-chats-list");
    private static final Condition VISIBLE_CONDITION = visible.because("Нет элемента");

    public MessagePage(String login, String password) {
        MainPage mainPage = new MainPage(login, password);
        mainPage.clickMessageBtn();
        isLoaded();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        $(CREATE_CHAT_BTN).shouldBe(VISIBLE_CONDITION);
    }

    public List<String> getListOfPeopleWithWhomThereIsCorrespondence() {
        $(CORRESPONDENCES_LIST_WRAPPER).shouldBe(VISIBLE_CONDITION);
        return $$(CORRESPONDENCES_LIST).texts();
    }
}
