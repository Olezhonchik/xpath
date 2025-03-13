package ru.vkusvillTests;

import org.junit.jupiter.api.Test;
import pages.PageObject;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithPageObject extends TestBase {

    PageObject pageObject = new PageObject();


    @Test
    void succesfullRegistrationTest() {
        pageObject.openPage()//Открытие страницы
                .setFirstName("Boba") //Ввод имени
                .setLastName("Fedotov")//Ввод фамилии
                .setEmail("BobaFedotov@mail.ru")//Ввод email
                .setGender() //Выбор гендера
                .setUserNumber("8800555353")    //Ввод номера телефона
                .setDateOfBirth("17", "October", "2000") //Ввод даты рождения
                .setSubjects("Phys")//Выбор предмета
                .setHobbies()//Выбор хобби
                .setFile("1.png")//Загрузка файла
                .setAddress("citizen of the world")//Ввод адреса
                .scrollDown()//Скролл до выбора штата
                // setTimeout(function() {debugger},4000); // Скрипт для холда devtools
                .setState() //Выбор штата
                .setCity()//Выбор города
                .submit()//Нажатие на кнопку "Submit"
                .checkResult("Student Name","Boba Fedotov")//Проверка правильности заполнения формы
                .checkResult("Student Email","BobaFedotov@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8800555353")
                .checkResult("Date of Birth", "17 October,2000")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "citizen of the world")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

        @Test
        void minimalDataRegistrationTest () {
            pageObject.openPage()//Открытие страницы
                    .setFirstName("Boba") //Ввод имени
                    .setLastName("Fedotov")//Ввод фамилии
                    .setGender()//Выбор гендера
                    .setUserNumber("88005553535")//Ввод номера телефона
                    .submit()//Нажатие на кнопку "Submit"
                    .checkMinimalDataResult("Student Name", "Boba Fedotov")
                    .checkMinimalDataResult("Mobile", "8800555353")
                    .checkMinimalDataResult("Gender","Other");
        }


        @Test
    void negativeRegistrationTest() {
        pageObject.openPage()//Открытие страницы
                .submit()//Нажатие на кнопку "Submit"
                .checkNegativeResult("border-color", "rgb(220, 53, 69)");//Проверка незаполненных полей
    }
}