package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private SubjectsComponent subjectsComponents = new SubjectsComponent();
    private HobbiesComponent hobbiesComponent = new HobbiesComponent();
    private UploadFilesComponent uploadFilesComponent = new UploadFilesComponent();
    private StateCityComponent stateCityComponent = new StateCityComponent();
    // locators
    private final SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderRadio = $(".custom-radio:nth-child(1) > .custom-control-label"),
            userNumberInput = $("#userNumber"),
            subjectsField = $("#subjectsInput"),
            hobbiesSport = $(".custom-checkbox:nth-child(1) > .custom-control-label"),
            hobbiesReading = $(".custom-checkbox:nth-child(2) > .custom-control-label"),
            hobbiesMusic = $(".custom-checkbox:nth-child(3) > .custom-control-label"),
            currentAddressInput = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("#submit"),
            close = $("#closeLargeModal"),
            resultsTable = $(".table-responsive"),
            submitWindow = $("#example-modal-sizes-title-lg"),
            modalWindow = $(".modal-content");

    //actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(Condition.textCaseSensitive("Practice Form"));
        return this;
    }


    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserGender() {
        userGenderRadio.click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsField.click();
        subjectsComponents.setSubjects(subject);
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesComponent.setMusic();
        hobbiesComponent.setReading();
        hobbiesComponent.setSports();
        return this;
    }

    public RegistrationPage uploadImage(File image) {
        uploadFilesComponent.uploadFile(image);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage chooseState(String state) {
        stateCityComponent.chooseState(state);
        return this;
    }

    public RegistrationPage chooseCity(String city) {
        stateCityComponent.chooseCity(city);
        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage checkTextModalWindow(String headerModalWindow) {
        submitWindow.shouldHave(text(headerModalWindow));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage clickClose() {
        close.click();
        return this;
    }

    public RegistrationPage checkModalWindowNotVisible() {
        modalWindow.shouldNot(visible);
        return this;
    }

}
