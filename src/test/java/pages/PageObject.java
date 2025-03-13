package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {

    private SelenideElement firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailInput = $x("//input[@id='userEmail']"),
            genderRadio = $x("//label[@for='gender-radio-3']"),
            userNumberInput = $x("//input[@id='userNumber']"),
            calendarInput = $x("//input[@id='dateOfBirthInput']"),
            subjectsInput = $x("//input[@id='subjectsInput']"),
            hobbiesInput = $x("//label[@for='hobbies-checkbox-3']"),
            fileInput = $x("//input[@id='uploadPicture']"),
            addressInput = $x("//textarea[@id='currentAddress']"),
            scrollDown = $x("//div[@class=' css-1wa3eu0-placeholder']"),
            stateClick = $x("//div[contains(@class, ' css-1wa3eu0-placeholder')]"),
            stateInput = $x("//div[contains(@id, 'react-select-3-option-1')]"),
            cityClick = $x("//div[contains(@id, 'city')]"),
            cityInput = $x("//div[contains(@id, 'react-select-4-option-0')]"),
            submit = $x("//button[contains(@id, 'submit')]"),
            tableResult = $x("//div[contains(@class, 'modal-content')]");

    CalendarComponent calendarComponent = new CalendarComponent();


    public PageObject openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }


    public PageObject setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PageObject setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PageObject setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PageObject setGender() {
        genderRadio.click();

        return this;
    }

    public PageObject setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PageObject setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PageObject setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PageObject setHobbies() {
        hobbiesInput.click();

        return this;
    }

    public PageObject setFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;
    }

    public PageObject setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PageObject scrollDown() {
        scrollDown.scrollIntoView(true);

        return this;
    }

    public PageObject setState() {
        stateClick.click();
        stateInput.click();

        return this;
    }

    public PageObject setCity() {
        cityClick.click();
        cityInput.click();

        return this;
    }

    public PageObject submit() {
        submit.click();

        return this;
    }

    public PageObject checkNegativeResult(String key, String value) {
        firstNameInput.shouldBe(cssValue(key, value));
        lastNameInput.shouldBe(cssValue(key, value));
        userNumberInput.shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-1']").shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-2']").shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-3']").shouldBe(cssValue(key, value));

        return this;
    }

    public PageObject checkResult(String key, String value) {
        tableResult.should(appear) //Проверка появления формы успешного заполнения
                .shouldHave(text(value));//Проверка правильности заполнения формы

        return this;
    }

    public PageObject checkMinimalDataResult(String key, String value) {
        tableResult.should(appear) //Проверка появления формы успешного заполнения
                .shouldHave(text(value));//Проверка правильности заполнения формы

        return this;

    }
}
