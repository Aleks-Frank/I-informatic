module org.example.projectinform {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires static lombok;
    requires ormlite.jdbc;
    requires org.apache.poi.ooxml;
    requires java.desktop;
    requires spire.doc.free;


    exports org.example.projectinform;
    opens org.example.projectinform to javafx.fxml;
    exports org.example.projectinform.Controllers.Student;
    opens org.example.projectinform.Controllers.Student to javafx.fxml;
    exports org.example.projectinform.Controllers.WindowWord;
    opens org.example.projectinform.Controllers.WindowWord to javafx.fxml;
    exports org.example.projectinform.Controllers.WindowGame;
    opens org.example.projectinform.Controllers.WindowGame to javafx.fxml;
    exports org.example.projectinform.Controllers.WindowEnterAndInput;
    opens org.example.projectinform.Controllers.WindowEnterAndInput to javafx.fxml;
    exports org.example.projectinform.DBRepository.Entity;
    opens org.example.projectinform.DBRepository.Entity;
    exports org.example.projectinform.Controllers.WindowWordInfoTasks;
    opens org.example.projectinform.Controllers.WindowWordInfoTasks to javafx.fxml;
    exports org.example.projectinform.Controllers.WindowIsCorrect;
    opens org.example.projectinform.Controllers.WindowIsCorrect to javafx.fxml;
}