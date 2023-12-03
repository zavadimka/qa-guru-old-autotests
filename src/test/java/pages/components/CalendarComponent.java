package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {

        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").scrollTo().selectOptionByValue(year);
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").first().click();
    }
}
