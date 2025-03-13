package pages.components;

import pages.PageObject;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate (String day, String month, String year){
        $x("//select[contains(@class, 'react-datepicker__year-select')]").selectOptionByValue("2000");
        $x("//select[contains (@class, 'react-datepicker__month-select')]").selectOptionByValue("9");
        $x("//div[contains(@class, 'react-datepicker__day--017') and text()='17']").click();

    }
}
