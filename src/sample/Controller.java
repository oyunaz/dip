package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import sun.plugin.javascript.navig4.LayerArray;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private GridPane mainGridPane;
    @FXML
    private Label header;
    @FXML
    private Button test;
    @FXML
    private Button tutor;
    @FXML
    private Label problem1;
    @FXML
    private Label problem2;
    @FXML
    private Label problem3;
    @FXML
    private TextField answer1;
    @FXML
    private Label evaluation1;

    private Generate generate;

    private Solution solution;

    public void initialize() {
        generate = new Generate();
        solution = new Solution();
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
            header.setVisible(false);                                        //кнопки главного меню делаются невидимыми
            tutor.setVisible(false);
            test.setVisible(false);
            DialogController dialogController = fxmlLoader.getController();
            String choiceResult = dialogController.getSelectedChoice();    //обработка выбора
            switch (choiceResult) {
                case "sum":                               //если была выбрана сумма
                    try {
                        problem1.setText(generate.generateSum());
                        answer1.setVisible(true);
                    } catch (NullPointerException e) {
                        problem1.setText("null");
                    }
                   break;
                case "multiply" :
                    try {
                        problem1.setText(generate.generateMultiply());
                    }catch (NullPointerException e){
                        problem1.setText("null");
                    }
                    break;
            }
        }
    }

    @FXML
    public void acceptAnswers(){
        String answer = answer1.getText();
        String rightAnswer = solution.getSolution(problem1.getText());
        if(answer.equals(rightAnswer)){
            evaluation1.setText("right !");
        }
    }

//    public void generateProblemsSum(){                  //генерация трех задач с суммой
//        try {
//            problem1.setText(generate.generateSum());
//            problem2.setText(generate.generateSum());
//            problem3.setText(generate.generateSum());
//        } catch (NullPointerException e) {
//            problem1.setText("null");
//        }
//    }
//
//    public void generateProblemMulti(){
//        try {
//            problem1.setText(generate.generateMultiply());
//            problem2.setText(generate.generateMultiply());
//            problem3.setText(generate.generateMultiply());
//        }catch (NullPointerException e){
//            problem1.setText("null");
//        }
//    }

}


