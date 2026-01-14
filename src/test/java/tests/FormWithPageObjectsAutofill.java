package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


import static com.codeborne.selenide.Configuration.*;

class FillFormTest {

    @Test
    void FormWithPageObjectsAutofill() {

        browser = "chrome";
        holdBrowserOpen = true;
        timeout = 10000;
        pageLoadTimeout = 60000;
        pageLoadStrategy = "eager";



        new PracticeFormPage()
                .openPage()
                .setName("Lamar", "Johnson")
                .setEmail("MakTrakher77@google.com")
                .selectMaleGender()
                .setPhone("5664678902")
                .setBirthDate("2045", "June", "15")
                .addSubject("Computer Science")
                .selectHobbies()
                .setAddress("OG Street")
                .selectStateAndCity("NCR", "Delhi")
                .submit();
    }
}
