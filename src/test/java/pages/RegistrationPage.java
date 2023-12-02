package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(String pageAddress){
        // открыть страницу формы
        open(pageAddress);

        // проверяем, что на странице формы
        $(".main-header").shouldHave(text("Practice Form"));

        // удаляем рекламные баннеры и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String firstName) {

        // ввести имя
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName (String lastName) {

        // ввести фамилию
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail (String email) {

        // ввести e-mail
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage setGender (String gender) {

        // выбрать пол
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber (String phoneNumber) {

        // ввести мобильный номер
        $("#userNumber").setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setDateOfBirthday (String dayOfBirthday, String monthOfBirthday, String yearOfBirthday) {

        // выбрать ДР
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(dayOfBirthday, monthOfBirthday, yearOfBirthday);

        return this;
    }

    public RegistrationPage setSubjects (String subject1, String subject2) {

        // ввести subjects
        $("#subjectsInput").val(subject1);
        // Кликните по первому элементу в выпадающем списке
        $(".subjects-auto-complete__option").click();

        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__option").click();

        return this;
    }

    public RegistrationPage setHobby (String hobby) {

        // выбрать хобби
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage addImage (String imagePath) {

        // прикрепить файл
        $("#uploadPicture").uploadFromClasspath(imagePath);

        return this;
    }

    public RegistrationPage setCurrentAddress (String currentAddress) {

        // ввести current address
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public RegistrationPage setStateAndCity (String state, String city) {

        // выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitRegistration(){

        // прокручиваем экран ниже
        executeJavaScript("window.scrollTo(0, 1000);");

        // подтвержаем заполнение формы
        $("#submit").click();

        //sleep(3000);

        return this;
    }

    public RegistrationPage checkSuccssesfulSubmit(){

        // проверяем, что появилась заполненная форма
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // закрываем форму
        $("#closeLargeModal").click();

        // проверяем, что опять на странице формы
        $(".main-header").shouldHave(text("Practice Form"));

        return this;
    }

}
