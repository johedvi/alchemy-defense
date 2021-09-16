module alchemydefense {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;

    opens alchemydefense to javafx.fxml;
    exports alchemydefense;
}