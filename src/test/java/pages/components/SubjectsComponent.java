package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    public void setSubjects(String subject) {
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys(subject);
        $("#react-select-2-option-0").click();
    }
}
