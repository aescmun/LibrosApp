module org.librosapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens org.librosapp to javafx.fxml;
    opens org.librosapp.controller to javafx.fxml;

    exports org.librosapp;
}