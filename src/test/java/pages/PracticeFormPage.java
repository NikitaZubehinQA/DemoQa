package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class PracticeFormPage {

    // URL
    private static final String PAGE_URL =
            "https://demoqa.com/automation-practice-form";

    // Locators
    private final SelenideElement firstName = Selenide.$("#firstName");
    private final SelenideElement lastName = Selenide.$("#lastName");
    private final SelenideElement email = Selenide.$("#userEmail");
    private final SelenideElement phone = Selenide.$("#userNumber");
    private final SelenideElement submitButton = Selenide.$("#submit");
    private final SelenideElement dateOfBirthInput = Selenide.$("#dateOfBirthInput");
    private final SelenideElement subjectsInput = Selenide.$("#subjectsInput");
    private final SelenideElement address = Selenide.$("#currentAddress");

    // Open
    public PracticeFormPage openPage() {
        Selenide.open(PAGE_URL);
        return this;
    }

    // Actions
    public PracticeFormPage setName(String first, String last) {
        firstName.setValue(first);
        lastName.setValue(last);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public PracticeFormPage selectMaleGender() {
        Selenide.$("label[for='gender-radio-1']").click();
        return this;
    }

    public PracticeFormPage setPhone(String value) {
        phone.setValue(value)
                .shouldHave(Condition.value(value));
        return this;
    }

    public PracticeFormPage setBirthDate(String year, String month, String day) {
        dateOfBirthInput.click();
        Selenide.$(".react-datepicker__year-select").selectOption(year);
        Selenide.$(".react-datepicker__month-select").selectOption(month);
        Selenide.$(
                ".react-datepicker__day--0" + day
        ).click();
        return this;
    }

    public PracticeFormPage addSubject(String subject) {
        subjectsInput.setValue(subject);
        Selenide.$$(".subjects-auto-complete__option")
                .findBy(Condition.text(subject))
                .click();
        return this;
    }

    public PracticeFormPage selectHobbies() {
        Selenide.$("label[for='hobbies-checkbox-1']").click();
        Selenide.$("label[for='hobbies-checkbox-3']").click();
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        address.scrollIntoView(true).setValue(value);
        return this;
    }

    public PracticeFormPage selectStateAndCity(String state, String city) {
        Selenide.$("#state").click();
        Selenide.$("input#react-select-3-input").sendKeys(state);
        Selenide.$("#react-select-3-option-0").click();

        Selenide.$("#city").click();
        Selenide.$("#react-select-4-option-0").click();
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}