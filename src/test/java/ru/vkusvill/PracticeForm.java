package ru.vkusvill;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $x("//input[@id='firstName']").setValue("Boba");
        $x("//input[@id='lastName']").setValue("Fedotov");
        $x("//input[@id='userEmail']").setValue("BobaFedotovLordofLogs@bibaboba.ru");
        $x("//label[@for='gender-radio-3']").click();
        $x("//input[@id='userNumber']").setValue("88005553535");
        //Дата рождения (будет вечером)
        $x("//input[@id='subjectsInput']").setValue("Phys").pressEnter();
        $x("//label[@for='hobbies-checkbox-3']").click();
        $x("//textarea[@id='currentAddress']").setValue("citizen of the world");

    }
}
