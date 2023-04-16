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

public class SearchPage extends LoadableComponent<SearchPage> {
    private static final SelenideElement NUMBER_OF_FOUND = $x("//*[@class='heading__unijc __h2__unijc']");
    private static final SelenideElement CLEAR_SEARCH_TEXT_BTN = $x(".//*[@data-icon-name='ico_close_16']/..");
    private static final SelenideElement MAIN_SEARCH_BAR = $x("//*[@placeholder='Введите запрос']");
    private static final SelenideElement SEARCH_HISTORY_WRAPPER = $x("//*[@class='suggestions-list__kud5x']");
    private static final ElementsCollection SEARCH_HISTORY = $$x(".//*[@class='suggestions-list__kud5x']/*");
    private static final Condition VISIBLE_CONDITION = visible.because("Нет элемента");

    public SearchPage() {
        isLoaded();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        $(NUMBER_OF_FOUND).shouldBe(VISIBLE_CONDITION);
        $(CLEAR_SEARCH_TEXT_BTN).shouldBe(VISIBLE_CONDITION);
    }

    public String getFoundLabel() {
        return $(NUMBER_OF_FOUND).shouldBe(VISIBLE_CONDITION).text();
    }

    public void clearSearchText() {
        $(CLEAR_SEARCH_TEXT_BTN).shouldBe(VISIBLE_CONDITION).click();
    }

    public List<String> getTextsFromHistoryOfSearch() {
        $(MAIN_SEARCH_BAR).shouldBe(VISIBLE_CONDITION).click();
        $(SEARCH_HISTORY_WRAPPER).shouldBe(VISIBLE_CONDITION);
        return $$(SEARCH_HISTORY).texts();
    }
}
