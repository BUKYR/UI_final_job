import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import testdata.TestBase;
import testdata.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class BonusCase {

        @BeforeAll
        public static void testConfiguration() {
            Configuration.baseUrl = "https://rit-it.com/";
            Configuration.browserSize = "1920x1080";
        }

        @ParameterizedTest
        @CsvFileSource(resources = "personalDataPolicy.csv")
        void personalDataPolicyValidation(String localItem, String localPolicyRef, String localPolicyText) {
            Selenide.open("/en");
            $(".lang-item-ru").click();
            $(localItem).click();
            $("#footer").$(byText(localPolicyRef)).click();
            $("#main").shouldHave(text(localPolicyText));
       }

       @Test
        void attribute() {

            open("/reshenija/camanager-sistema-videoregistracii-i-predotvrashhenija-stolknovenij/");
            $("[type=checkbox]").click();
            $("[value=Отправить]").shouldNotHave(Condition.attribute("disabled"));

           sleep(5000);

       }
}


