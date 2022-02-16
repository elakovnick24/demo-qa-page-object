package pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadFilesComponent {

    public void uploadFile(File image) {
        $("#uploadPicture").uploadFile(new File(String.valueOf(image)));
    }
}
