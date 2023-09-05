module com.example.plantsvszombies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.plantsvszombies to javafx.fxml;
    exports com.example.plantsvszombies;
}