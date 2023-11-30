package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTestsWithComments {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
        //Configuration.browser="firefox";
    }

    @Test
    void successfulRegistrationTest() {
        // открыть страницу формы
        open("/automation-practice-form");

        // проверяем, что на странице формы
        $(".main-header").shouldHave(text("Practice Form"));

        // удаляем рекламные баннеры и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // ввести имя
        $("#firstName").setValue("Ivan");

        // ввести фамилию
        $("#lastName").setValue("Ivanov");

        // ввести e-mail
        $("#userEmail").setValue("ivanov@ivanov.com");

        // выбрать пол
        $("#genterWrapper").$(byText("Male")).click(); // лучший способ
//        $("#gender-radio-1").parent().click(); 2 способ
//        $(byText("Male")).click(); // 3 способ, но не очень хороший. Могут быть другие совпадения и пр.
//        executeJavaScript("arguments[0].click();", $("#gender-radio-1")); // 4 способ
//        $("label[for=gender-radio-1]").click(); // 5 способ

        // ввести мобильный номер
        $("#userNumber").setValue("0123456789");

        // выбрать ДР
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").scrollTo().selectOptionByValue("1985");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
//        $(".react-datepicker__month-select").selectOptionByValue("6"); // через byValue
        $$(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").first().click();
//        $(".react-datepicker__day--030").click(); // так можно выбрать дату из прошлого месяца

        // ввести subjects
        $("#subjectsInput").val("Math");
        // Кликните по первому элементу в выпадающем списке
        $(".subjects-auto-complete__option").click();
//        $("#subjectsInput").pressEnter(); // можно и через Enter
        $("#subjectsInput").val("English");
        $(".subjects-auto-complete__option").click();

        // выбрать хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        executeJavaScript("arguments[0].click();", $("#hobbies-checkbox-1")); // 2 способ

        // прикрепить файл
        $("#uploadPicture").uploadFromClasspath("img/testImage.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/testImage.png")); // 2 способ

        // ввести current address
        $("#currentAddress").setValue("Montenegro");

        // выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click(); // 2 способ
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        $("#react-select-4-option-0").click(); // 2 способ

        // прокручиваем экран ниже
        executeJavaScript("window.scrollTo(0, 1000);");

        // подтвержаем заполнение формы
        $("#submit").click();

        sleep(3000);

        // проверяем, что появилась заполненная форма
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // закрываем форму
        $("#closeLargeModal").click();

        // проверяем, что опять на странице формы
        $(".main-header").shouldHave(text("Practice Form"));


/*
        Способы через moveToElement
        // выбрать штат и город
        var state = $("#state");
        var actions = new Actions(getWebDriver());
        actions.moveToElement(state).click().build().perform();

        var stateValue = $("#react-select-3-option-0");
        actions.moveToElement(stateValue).click().build().perform();

        var city = $("#city");
        actions.moveToElement(city).click().build().perform();
        sleep(2000);
        var cityValue = $("#react-select-4-option-0");
        actions.moveToElement(cityValue).click().build().perform();

        // подтвержаем заполнение формы
        var submit = $("#submit");
        actions.moveToElement(submit).click().build().perform();
*/
    }
}
