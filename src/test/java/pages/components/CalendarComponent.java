package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromArray;

public class CalendarComponent {

    public void setDate(String day) {

        String[] months = new String[] {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};
        String month = getRandomItemFromArray(months);
        String year = "" + getRandomInt(1920, 2010);

        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").scrollTo().selectOptionByValue(year);
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").first().click();
    }
}
