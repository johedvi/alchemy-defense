module alchemydefense {
    requires javafx.controls;
    requires javafx.fxml;

    opens alchemydefense to javafx.fxml;
    exports alchemydefense;
}