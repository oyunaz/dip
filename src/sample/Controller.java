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
    private TextField answer2;
    @FXML
    private TextField answer3;
    @FXML
    private Label evaluation1;
    @FXML
    private RadioButton randomFunc;

    private Generate generate;

    private Solution solution;

    public static String mapleFunction;

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
//            header.setVisible(false);                                        //кнопки главного меню делаются невидимыми
//            tutor.setVisible(false);
//            test.setVisible(false);
            DialogController dialogController = fxmlLoader.getController();
            String choiceResult = dialogController.getSelectedChoice();    //обработка выбора
            gen(choiceResult);
        }
    }

    @FXML
    public void showChoiceDialogTest(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Производную чего хотите искать ?");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("problemChoiceTest.fxml"));
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
//            header.setVisible(false);                                        //кнопки главного меню делаются невидимыми
//            tutor.setVisible(false);
//            test.setVisible(false);
            DialogController dialogController = fxmlLoader.getController();
            String choiceResult = dialogController.getSelectedChoice();    //обработка выбора
            gen(choiceResult);
        }
    }

    @FXML
    public void acceptAnswersTutor() {
        String answer = answer1.getText();
        String rightAnswer = solution.getSolution(problem1.getText());
        if (answer.equals(rightAnswer)) {
            evaluation1.setText("right !");
        }
    }

    public void gen(String choiceResult){
        switch (choiceResult) {
            case "sum":                               //если была выбрана сумма
                try {
                    problem1.setText(generate.generateSum());
                    problem2.setText(generate.generateSum());
                    problem3.setText(generate.generateSum());
                    answer1.setVisible(true);
                    answer2.setVisible(true);
                    answer3.setVisible(true);
                } catch (NullPointerException e) {
                    problem1.setText("null");
                    problem2.setText("null");
                    problem3.setText("null");
                }

                break;
            case "multiply":
                try {
                    problem1.setText(generate.generateMultiply());
                    problem2.setText(generate.generateMultiply());
                    problem3.setText(generate.generateMultiply());
                    answer1.setVisible(true);
                    answer2.setVisible(true);
                    answer3.setVisible(true);
                } catch (NullPointerException e) {
                    problem1.setText("null");
                    problem2.setText("null");
                    problem3.setText("null");
                }
                break;
            case "division":
                try {
                    problem1.setText(generate.generateDivision());
                    problem2.setText(generate.generateDivision());
                    problem3.setText(generate.generateDivision());
                    answer1.setVisible(true);
                    answer2.setVisible(true);
                    answer3.setVisible(true);
                }catch (NullPointerException e){
                    problem1.setText("null");
                }
                break;
            case "complexFunc":
                try{
                    problem1.setText(generate.generateComplex());
                    problem2.setText(generate.generateComplex());
                    problem3.setText(generate.generateComplex());
                    answer1.setVisible(true);
                    answer2.setVisible(true);
                    answer3.setVisible(true);
                }catch (NullPointerException e){
                    problem1.setText("null");
                }
                break;
            case "randomFunc":
                try{
                    problem1.setText(generate.generateRandomFunc());
                    problem2.setText(generate.generateRandomFunc());
                    problem3.setText(generate.generateRandomFunc());
                    answer1.setVisible(true);
                    answer2.setVisible(true);
                    answer3.setVisible(true);
                }catch (NullPointerException e){
                    problem1.setText("null");
                }
                break;
        }
    }

}


