module edu.ucsd.spendingtracker {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ucsd.spendingtracker to javafx.fxml;
    exports edu.ucsd.spendingtracker;
}
