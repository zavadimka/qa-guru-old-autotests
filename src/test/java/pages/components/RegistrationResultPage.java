package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultPage {

    public RegistrationResultPage successfulSubmit(){

        // проверяем, что появилась заполненная форма
        $(".modal-dialog").should(appear);

        // проверяем, что заполненная форма содержит текст "Thanks for submitting the form"
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationResultPage successfulFormFilling (String key, String value){

        $(".table-responsive").$(byText(key))
                        .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationResultPage successfulReturnToForm (){

        // закрываем форму подтверждения
        $("#closeLargeModal").click();

        // проверяем, что опять на странице формы
        $(".main-header").shouldHave(text("Practice Form"));

        return this;
    }
}
