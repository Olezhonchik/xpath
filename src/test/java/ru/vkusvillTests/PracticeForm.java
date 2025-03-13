package ru.vkusvillTests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $x("//input[@id='firstName']").setValue("Boba");    //Ввод имени
        $x("//input[@id='lastName']").setValue("Fedotov");  //Ввод фамилии
        $x("//input[@id='userEmail']").setValue("BobaFedotov@mail.ru"); //Ввод email
        $x("//label[@for='gender-radio-3']").click(); //Выбор гендера
        $x("//input[@id='userNumber']").setValue("88005553535");    //Ввод номера телефона
        $x("//input[@id='dateOfBirthInput']").click(); //Ввод даты рождения
        $x("//select[contains(@class, 'react-datepicker__year-select')]").selectOptionByValue("2000");
        $x("//select[contains (@class, 'react-datepicker__month-select')]").selectOptionByValue("9");
        $x("//div[contains(@class, 'react-datepicker__day--017') and text()='17']").click();
        $x("//input[@id='subjectsInput']").setValue("Phys").pressEnter(); //Выбор предмета
        $x("//label[@for='hobbies-checkbox-3']").click(); //Выбор хобби
        $x("//textarea[@id='currentAddress']").setValue("citizen of the world"); //Ввод адреса
        $x("//input[@id='uploadPicture']").uploadFromClasspath("1.png");//Загрузка файла

        // setTimeout(function() {debugger},4000); // Скрипт для холда devtools
        $x("//div[@class=' css-1wa3eu0-placeholder']").scrollIntoView(true);//Скролл до выбора штата

        $x("//div[contains(@class, ' css-1wa3eu0-placeholder')]").click(); //Нажатие на выбор штата
        $x("//div[contains(@id, 'react-select-3-option-1')]").click(); //Выбор штата
        $x("//div[contains(@id, 'city')]").click(); //Нажатие на выбор города
        $x("//div[contains(@id, 'react-select-4-option-0')]").click(); //Нажатие на выбор города
        $x("//button[contains(@id, 'submit')]").click(); //Нажатие на кнопку "Submit"

        //Проверки
        $x("//div[contains(@class, 'modal-dialog modal-lg')]").should(appear); //Проверка появления формы успешного заполнения
        $x("//div[contains(@id, 'example-modal-sizes-title-lg')]").shouldHave(text("Thanks for submitting the form")); //Проверка появления формы успешного заполнения
        $x("//div[contains(@class, 'modal-body')]").shouldHave(text("Boba Fedotov"), text("BobaFedotov@mail.ru"), text("8800555353"));//Проверка правильности заполнения формы

    }
}