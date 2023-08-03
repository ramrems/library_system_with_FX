module com.example.librarydemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.javadoc;

    opens com.example.librarydemo to javafx.fxml;
    exports com.example.librarydemo;
}