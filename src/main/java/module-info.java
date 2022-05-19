module org.openjfx.testgruppprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens org.openjfx.testgruppprojekt to javafx.fxml;
    exports org.openjfx.testgruppprojekt;
}
