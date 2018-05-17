package sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DialogController {
    @FXML
    private ToggleGroup problemChoiceGroup;
    @FXML
    private RadioButton sum;
    @FXML
    private RadioButton multiply;
    @FXML
    private RadioButton division;
    @FXML
    private RadioButton complexFunc;

    @FXML

    public String getSelectedChoice() {
        RadioButton selectedRadio = (RadioButton) problemChoiceGroup.getSelectedToggle();
        if (selectedRadio == null) {
            return null;
        }
        if (selectedRadio == sum)
            return "sum";
        if (selectedRadio == multiply)
            return "multiply";
        if (selectedRadio == division)
            return "division";
        if (selectedRadio == complexFunc)
            return "complexFunc";

        return selectedRadio.getId();
    }
}
