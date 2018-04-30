package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private GridPane mainGridPane;
    @FXML
    private Label problem1;
    @FXML
    private Label problem2;
    @FXML
    private Label problem3;

    private Generate generate;

    public void initialize() {
        generate = new Generate();
    }

    @FXML
    public void showChoiceDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Производную чего хотите искать ?");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("problemChoice.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.printf("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController dialogController = fxmlLoader.getController();
            String choiceResult = dialogController.getSelectedChoice();    //обработка выбора
            switch (choiceResult) {
                case "sum":                               //если была выбрана сумма
                   generateProblemsSum();
                   break;
                case "multiply" :
                    generateProblemMulti();
                    break;
            }
        }
    }

    public void generateProblemsSum(){                  //генерация трех задач с суммой
        try {
            problem1.setText(generate.generateSum());
            problem2.setText(generate.generateSum());
            problem3.setText(generate.generateSum());
        } catch (NullPointerException e) {
            problem1.setText("null");
        }
    }

    public void generateProblemMulti(){
        try {
            problem1.setText(generate.generateMultiply());
            problem2.setText(generate.generateMultiply());
            problem3.setText(generate.generateMultiply());
        }catch (NullPointerException e){
            problem1.setText("null");
        }
    }
}


