package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
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

        // ввести мобильный номер
        $("#userNumber").setValue("0123456789");

        // выбрать ДР
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").scrollTo().selectOptionByValue("1985");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $$(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").first().click();

        // ввести subjects
        $("#subjectsInput").val("Math");
        // Кликните по первому элементу в выпадающем списке
        $(".subjects-auto-complete__option").click();

        $("#subjectsInput").val("English");
        $(".subjects-auto-complete__option").click();

        // выбрать хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();

        // прикрепить файл
        $("#uploadPicture").uploadFromClasspath("img/testImage.png");

        // ввести current address
        $("#currentAddress").setValue("Montenegro");

        // выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

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
    }
}
