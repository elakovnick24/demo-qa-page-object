package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    public void chooseState(String state){
        $("#react-select-3-input").setValue(state).pressEnter();
    }

    public void chooseCity(String city){
        $("#react-select-4-input").setValue(city).pressEnter();
    }
}
