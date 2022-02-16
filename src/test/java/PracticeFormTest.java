import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Student";
    String lastName = "Guru";
    String userEmail = "qaguru@guru.com";
    String userNumber = "9111117777";
    String userGender = "Male";
    String monthBirth = "September";
    String yearBirth = "1993";
    String dayBirth = "2";
    String subject = "Computer Science";
    String currentAddress = "196084 SPB";
    String state = "Haryana";
    String city = "Panipat";
    File image = new File("src/test/resources/mini_yoda.jpeg");
    String textHeaderModalWindow = "Thanks for submitting the form";

    String fieldStName = "Student Name";
    String fieldStEmail = "Student Email";
    String fieldGender = "Gender";
    String fieldMobile = "Mobile";
    String fieldDBirth = "Date of Birth";
    String resultBirth = dayBirth + " " + " " + monthBirth + "," + yearBirth;
    String fieldSubjects = "Subjects";
    String fieldHobbies = "Hobbies";
    String resultHobbies = "Music, Reading, Sports";
    String fieldPictute = "Picture";
    String resultPicture = "mini_yoda.jpeg";
    String fieldAddress = "Address";
    String fieldStateCity = "State and City";
    String resultStateCity = state + " " + city;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "3840x2160";
    }

    @Test
    public void happyPathTest() throws InterruptedException {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender()
                .setUserNumber(userNumber)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setUserNumber(userNumber)
                .setSubjects(subject)
                .setHobbies()
                .uploadImage(image)
                .setCurrentAddress(currentAddress)
                .chooseState(state)
                .chooseCity(city)
                .clickSubmit()
                .checkTextModalWindow(textHeaderModalWindow)
                .checkForm(fieldStName, firstName)
                .checkForm(fieldStEmail, userEmail)
                .checkForm(fieldGender, userGender)
                .checkForm(fieldMobile, userNumber)
                .checkForm(fieldDBirth, resultBirth)
                .checkForm(fieldSubjects, subject)
                .checkForm(fieldHobbies, resultHobbies)
                .checkForm(fieldPictute, resultPicture)
                .checkForm(fieldAddress, currentAddress)
                .checkForm(fieldStateCity, resultStateCity)
                .clickClose()
                .checkModalWindowNotVisible();
    }
}
