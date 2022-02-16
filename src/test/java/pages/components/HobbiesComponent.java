package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    public void setSports() {
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
    }

    public void setReading() {
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
    }

    public void setMusic() {
        $(".custom-checkbox:nth-child(3) > .custom-control-label").click();
    }
}
