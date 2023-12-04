package pages;

import pages.components.CalendarComponent;
import pages.components.RegistrationResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    public RegistrationPage openPage(String pageAddress) {
        // открыть страницу формы
        open(pageAddress);

        // проверяем, что на странице формы
        $(".main-header").shouldHave(text("Practice Form"));

        // удаляем рекламные баннеры и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {

        // ввести имя
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {

        // ввести фамилию
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {

        // ввести e-mail
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {

        // выбрать пол
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {

        // ввести мобильный номер
        $("#userNumber").setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setDateOfBirthday(String dayOfBirthday) {

        // выбрать ДР
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(dayOfBirthday);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {

        // ввести subjects
        $("#subjectsInput").val(subject);
        // Кликните по первому элементу в выпадающем списке
        $(".subjects-auto-complete__option").click();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {

        // выбрать хобби
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage addImage(String imagePath) {

        // прикрепить файл
        $("#uploadPicture").uploadFromClasspath(imagePath);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {

        // ввести current address
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {

        // выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitRegistration() {

        // прокручиваем экран ниже
        executeJavaScript("window.scrollTo(0, 1000);");

        sleep(3000);

        // подтвержаем заполнение формы
        $("#submit").click();

        return this;
    }

    public RegistrationPage successfulSubmit() {

        registrationResultPage.successfulSubmit();

        return this;
    }

    public RegistrationPage successfulFormFilling(String key, String value) {

        registrationResultPage.successfulFormFilling(key, value);

        return this;
    }

    public RegistrationPage successfulReturnToForm() {

        registrationResultPage.successfulReturnToForm();

        return this;
    }
}
