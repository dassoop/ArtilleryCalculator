module com.dassoop.artillerycalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dassoop.artillerycalculator to javafx.fxml;
    exports com.dassoop.artillerycalculator;
}