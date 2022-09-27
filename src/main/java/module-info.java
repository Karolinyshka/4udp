module com.example.udp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.udp4 to javafx.fxml;
    exports com.example.udp4;
}