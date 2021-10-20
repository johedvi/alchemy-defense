module alchemydefense {
    requires javafx.controls;
    requires java.datatransfer;
    requires java.desktop;

    opens alchemydefense to javafx.fxml;
    exports alchemydefense;
    exports alchemydefense.Model;
    exports alchemydefense.Model.Board.Grid;
    exports alchemydefense.Model.Towers;
    exports alchemydefense.Utility;
    exports alchemydefense.Model.Foe;
    exports alchemydefense.Model.Board;
    exports alchemydefense.Controller;
    exports alchemydefense.Model.Player;
}