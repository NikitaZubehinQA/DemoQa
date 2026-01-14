package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class FormAutofillWithJavaFaker {
    WebDriver driver;



    @Test
    void FillFormTest(){

        browser = "chrome";
        holdBrowserOpen = true;
        timeout = 10000;
        pageLoadTimeout = 60000;
        pageLoadStrategy = "eager";
        var element = $("#submit");

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();



        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        // Сначала вводим значение
        $("#userNumber").setValue("123456789");
        // Потом проверяем
        $("#userNumber").shouldHave(value("123456789"));
        //плейсхолдер календаря (год)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__year-select").selectOptionByValue("2045");
        $(".react-datepicker__year-select").selectOption("2045");
        //плейсхолдер каленадря (месяц)
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--015").click();
        //
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("Computer Science");
        $(".subjects-auto-complete__menu").shouldBe(visible);
        $$(".subjects-auto-complete__option").findBy(text("Computer Science")).click();
        // Sports (value="1")
        $("label[for='hobbies-checkbox-1']").click();
        // Music (value="3")
        $("label[for='hobbies-checkbox-3']").click();
        //scroll
        executeJavaScript("window.scrollBy({top: 1000, behavior: 'smooth'});");
        sleep(1000);
        $("#currentAddress").setValue("OG Street");
        // css-tlfecz-indicatorContainer
        // 1. Кликнуть на контейнер State
        $("#state").scrollIntoView(true).click();

        // 2. Ввести текст в скрытое поле ввода
        $("input#react-select-3-input").sendKeys("NCR");

        // 3. Выбрать опцию из выпадающего списка
        $("#react-select-3-option-0").click();
        //1. Кликнуть на контейнер citi
        $("#city").click();
        // 2. Ввести текст в скрытое поле ввода
        $("#react-select-4-option-0").click();
        // Финальный Submit!
        $("#submit").click();


    }
}