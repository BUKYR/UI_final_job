import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.provider.CsvFileSource;
import testdata.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static testdata.TestSource.*;


public class LandingTest extends TestBase {

    TestData TestData = new TestData();


    @Test
    @DisplayName("Проверка валидации email input на странице 'Блог'")
    void emailInputValidationTest() {
        TestData.openMainPage()
                .clickOnHeaderMenuElement(mediaText, blogText)
                .setEmailValue()
                .checkValidation();
    }

    @Test
    @DisplayName("Проверка раздела 'Проекты' в хедер меню и названия раздела")
    void pageOfProjectTitleTest() {
        TestData.openMainPage()
                .clickOnHeaderMenuElement(companyText, projectsText)
                .checkTitleOfPage();
    }

    @ParameterizedTest
    @CsvSource(value =  {
            ".soc-vk, https://www.linkedin.com",
            ".soc-insta, https://vk.com/public217753469", // это ошибка фронта
            ".soc-tw, https://consent.youtube.com"
    })
    @DisplayName("Проверка перехода на страницу соцсети по кнопке в хедер меню")
    void socialNetworkTest(String socialPin, String socialUrl) {
        TestData.openMainPage()
                .clickOnSocialNetwork(socialPin)
                .checkSocialNetworkURL(socialUrl);
    }

    @Test
    @DisplayName("Проверка гамбергер-меню")
    void hamburgerBoxMenuTest() {
        TestData.openMainPage()
                .clickOnHamburgerMenu()
                .checkContactsInHamburger();
    }

    @ParameterizedTest
    @CsvSource(value =  {
            ".lang-item-en, Company",
            ".lang-item-ru, Компания"
    })
    @DisplayName("Проверка меню локализации")
    void testOfLocalizationChange(String localItem, String companyText) {
        TestData.openMainPage()
                .checkPageLocalization(localItem, companyText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "personalDataPolicy.csv")
    @DisplayName("Проверка текста соглашения о персональных данных на двух языках")
    void personalDataPolicyValidation(String localItem, String localPolicyRef, String localPolicyText) {
        TestData.openMainPage()
                .searchFooterElement(localItem, localPolicyRef)
                .textPolicyValidation(localPolicyText);
    }

    @Test
    @DisplayName("Проверка активации кнопки после согласия с политикой конфиденциальности")
    void buttonCheckAfterCheckboxActivation() {
        TestData.openTargetUrl(videoregistraciyaUrl)
                .clickOnCheckbox()
                .checkAttr();
    }

}