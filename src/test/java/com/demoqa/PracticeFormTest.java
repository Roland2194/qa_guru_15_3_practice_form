package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
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
        $(byId("firstName")).setValue(newTest.getFirstName());
        $(byId("lastName")).setValue(newTest.getLastName());
        $(byId("userEmail")).setValue(newTest.getEmail());
        $$(byClassName("custom-control-label")).findBy(text(newTest.getGender())).click();
        $(byId("userNumber")).setValue(newTest.getUserNumber());
        $(byId("dateOfBirthInput")).click();
        $(byClassName("react-datepicker__month-select")).click();
        $(byClassName("react-datepicker__month-select")).selectOption("June");
        $(byClassName("react-datepicker__year-select")).click();
        $(byClassName("react-datepicker__year-select")).selectOption("1994");
        $(by("class", "react-datepicker__day react-datepicker__day--021")).doubleClick();
        $(byId("subjectsInput")).setValue(newTest.getSubjects()).pressEnter();
        $$(byClassName("custom-control-label")).findBy(text(newTest.getHobbies())).click();
        $(byId("uploadPicture")).uploadFile(newTest.getPicture());
        $(byId("currentAddress")).setValue(newTest.getAddress());
        $(byId("react-select-3-input")).setValue(newTest.getState()).pressEnter();
        $(byId("react-select-4-input")).setValue(newTest.getCity()).pressEnter();
        $(byId("submit")).click();

        $$(byClassName("table-responsive")).findBy(text("Student Name")).shouldHave(text(newTest.getFirstName() + " " + newTest.getLastName()));
        $$(byClassName("table-responsive")).findBy(text("Student Email")).shouldHave(text(newTest.getEmail()));
        $$(byClassName("table-responsive")).findBy(text("Gender")).shouldHave(text(newTest.getGender()));
        $$(byClassName("table-responsive")).findBy(text("Mobile")).shouldHave(text(newTest.getUserNumber()));
        $$(byClassName("table-responsive")).findBy(text("Date of Birth")).shouldHave(text("21 June,1994"));
        $$(byClassName("table-responsive")).findBy(text("Subjects")).shouldHave(text(newTest.getSubjects()));
        $$(byClassName("table-responsive")).findBy(text("Hobbies")).shouldHave(text(newTest.getHobbies()));
        $$(byClassName("table-responsive")).findBy(text("Picture")).shouldHave(text(newTest.getPicture().getName()));
        $$(byClassName("table-responsive")).findBy(text("Address")).shouldHave(text(newTest.getAddress()));
        $$(byClassName("table-responsive")).findBy(text("State and City")).shouldHave((text(newTest.getState()))).shouldHave(text(" " + newTest.getCity()));
    }
}
