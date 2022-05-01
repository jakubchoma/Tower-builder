module com.example.towerka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.towerka to javafx.fxml;
    exports com.example.towerka;
}