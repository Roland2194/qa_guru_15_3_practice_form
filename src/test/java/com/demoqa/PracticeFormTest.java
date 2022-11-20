package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {

    DataTests newTest = new DataTests();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void practiceFormNewTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(newTest.getFirstName());
        $("#lastName").setValue(newTest.getLastName());
        $("#userEmail").setValue(newTest.getEmail());
        $$(".custom-control-label").findBy(text(newTest.getGender())).click();
        $("#userNumber").setValue(newTest.getUserNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--021:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(newTest.getSubjects()).pressEnter();
        $$(".custom-control-label").findBy(text(newTest.getHobbies())).click();
        $("#uploadPicture").uploadFile(newTest.getPicture());
        $("#currentAddress").setValue(newTest.getAddress());
        $("#react-select-3-input").setValue(newTest.getState()).pressEnter();
        $("#react-select-4-input").setValue(newTest.getCity()).pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(newTest.getFirstName() + " " + newTest.getLastName()), text(newTest.getEmail()),
                text(newTest.getGender()), text(newTest.getUserNumber()), text("21 June,1994"), text(newTest.getSubjects()),text(newTest.getHobbies()), text(newTest.getPicture().getName()),
                text(newTest.getAddress()), text(newTest.getState()), text(" " + newTest.getCity()));
    }
}
