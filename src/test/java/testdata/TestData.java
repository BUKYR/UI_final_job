package testdata;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static testdata.TestSource.*;


public class TestData {

    @Step("Открытие главной страницы")
    public TestData openMainPage() {
        Selenide.open("/en");
        $(".lang-item-ru").click();
        return this;
    }

    @Step("Выбор элемента в хедере")
    public TestData clickOnHeaderMenuElement(String menuItem, String subMenuItem) {
        $(headerWrapper).$(byText(menuItem)).hover();
        $(byText(subMenuItem)).click();

        return this;
    }

    @Step("Подстановка неверного значения")
    public TestData setEmailValue() {
        $(s2email).setValue(incorrectMail);
        return this;
    }

    @Step("Проверка валидации поля")
    public TestData checkValidation() {
        $(subscribeButton).click();
        $(s2error).shouldHave(text(errorText));
        return this;
    }

    @Step("Клик на значок социальной сети")
    public TestData clickOnSocialNetwork(String socialPin) {
        $(headerWrapper).$(topBar).$(socialPin).click();
        return this;
    }

    @Step("Проверка перехода на страницу социальной сети")
    public TestData checkSocialNetworkURL(String socialUrl) {
        switchTo().window(1);
        webdriver().shouldHave(urlStartingWith(socialUrl));

        return this;
    }

    @Step("Проверка заголовка страницы")
    public TestData checkTitleOfPage() {
        $(wrapper).$(content).shouldHave(text(projectsText));
        return this;
    }

    @Step("Открытие гамбургер меню")
    public TestData clickOnHamburgerMenu() {
        $(humburgBox).click();
        return this;
    }

    @Step("Проверка информации в меню")
    public TestData checkContactsInHamburger() {
        $(popupWrapper).$(colInner).$(bigMenuCategory, 2).
                shouldHave(text(numberText), text(contactsText), text(emailText));

        return this;
    }

    @Step("Проверка смены локализации")
    public TestData checkPageLocalization(String localItem, String companyText) {
        $(localItem).click();
        $(masthead).$(byText(companyText)).shouldBe(Condition.visible);
        return this;

    }

    @Step("Поиск элемента в футере по тексту")
    public TestData searchFooterElement(String localItem, String localPolicyRef) {
        $(localItem).click();
        $(footer).$(byText(localPolicyRef)).click();
        return this;
    }

    @Step("Проверка теста на странице согласия обработки персональных данных")
    public TestData textPolicyValidation(String localPolicyText) {
        $(main).shouldHave(text(localPolicyText));
        return this;
    }

    @Step("Клик на чекбокс")
    public TestData clickOnCheckbox() {
        $(checkbox).click();
        return this;
    }

    @Step("Проверка атрибута у элемента")
    public TestData checkAttr() {
        $(buttonPost).shouldNotHave(Condition.attribute(attrDisable));
        return this;
    }

    @Step("Открытие целевой страницы")
    public TestData openTargetUrl(String targetUrl) {
        open(targetUrl);
        return this;
    }
}


