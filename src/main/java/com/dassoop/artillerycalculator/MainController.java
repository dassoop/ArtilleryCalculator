package com.dassoop.artillerycalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    private Label welcomeText;

    @FXML
    private TextField textField_meterInput = new TextField();

    @FXML
    private TextField textField_milOutput = new TextField();

    @FXML
    private CheckBox checkBox_russianOption = new CheckBox();

    Delta delta = new Delta();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }


    public MainController()
    {

    }



    @FXML public void panePressed(MouseEvent me)
    {
        Stage stage = (Stage)((Node) me.getSource()).getScene().getWindow();

        delta.x = stage.getX() - me.getScreenX();
        delta.y = stage.getY() - me.getScreenY();
    }

    @FXML public void paneDragged(MouseEvent me)
    {
        Stage stage = (Stage)((Node) me.getSource()).getScene().getWindow();
        stage.setX(delta.x + me.getScreenX());
        stage.setY(delta.y + me.getScreenY());
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void calculateMils()
    {
        int meters = Integer.parseInt(textField_meterInput.getText());


        long result = 0;
        if(meters >= 100 && meters <= 1600)
        {
            int distance = (100 * meters) / 1600;


            if(!checkBox_russianOption.isSelected())
            {
                double m = -0.23703;
                double b = 1001.46;
                result = Math.round(m * meters + b);
            }
            else
            {
                double k = 21.33;
                double l = 100;
                result = Math.round(1120 - (((meters / l) - 1) * k));
            }
        }

        textField_milOutput.setText(String.valueOf(result));
    }


//        if (input >= 100 && input <= 1600) {
//    let distanceResult = (100 * input) / 1600;
//
//    let realResult = 0;
//
//    if (teams == "Original") {
//        let m = -0.23703;
//        let b = 1001.46;
//        realResult = Math.round( m * input + b );
//    } else if (teams == "Russian") {
//        let k = 21.33;
//        let l = 100;
//        realResult = Math.round( 1120 - (((input / l) - 1) * k)) ;
//    }
}