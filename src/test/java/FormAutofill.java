import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration.*;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

import com.codeborne.selenide.conditions.Value;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAutofill {
    WebDriver driver;



    @Test
    void FillFormTest(){

        browser = "chrome";
        holdBrowserOpen = true;
        var element = $("#submit");

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Lamar");
        $("#lastName").setValue("Johnson");
        $("#userEmail").setValue("MakTrakher77@google.com");
        $("label[for='gender-radio-1']").click();
        // Сначала вводим значение
        $("#userNumber").setValue("5664678902");
        // Потом проверяем
        $("#userNumber").shouldHave(value("5664678902"));
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
