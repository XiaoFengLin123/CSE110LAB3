package edu.ucsd.spendingtracker;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.presenter.PresenterManager;
import edu.ucsd.spendingtracker.presenter.SpendingPresenter;
import edu.ucsd.spendingtracker.presenter.SummaryPresenter;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;
import edu.ucsd.spendingtracker.view.SpendingView;
import edu.ucsd.spendingtracker.view.SummaryView;
import javafx.application.Application;
import javafx.stage.Stage;

// import edu.ucsd.spendingtracker.model.Category;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Text;
// import javafx.scene.text.TextAlignment;
// import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        InMemoryDataSource dataSource = InMemoryDataSource.getDefaultDataSource();
        ExpenseRepository repository = new ExpenseRepository(dataSource);

        Model sharedModel = new Model(repository);

        SpendingView spendingView = new SpendingView();
        SummaryView summaryView = new SummaryView();

        SpendingPresenter listPresenter = new SpendingPresenter(sharedModel, spendingView);
        SummaryPresenter summaryPresenter = new SummaryPresenter(sharedModel, summaryView);

        PresenterManager manager = new PresenterManager();
        manager.defineInteraction(primaryStage, "Spending Tracker", listPresenter, summaryPresenter);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// class Expense extends HBox {

//     private Label index;
//     private Label expenseName;
//     private Label categoryLabel;
//     private Label amountLabel;

//     Expense(int idx, String name, Category cat, double amount) {
//         this.setPrefSize(500, 40);
//         this.setPadding(new Insets(5, 10, 5, 10));
//         this.setAlignment(Pos.CENTER_LEFT);
//         this.setSpacing(10);
        
//         // Apply the category color to the entire row
//         this.setStyle("-fx-background-color: " + cat.color + "; -fx-border-color: #D3D3D3; -fx-border-width: 0 0 1 0; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px;");

//         index = new Label(idx + ".");
//         index.setPrefWidth(30);

//         expenseName = new Label(name);
//         expenseName.setPrefWidth(220);

//         categoryLabel = new Label("[" + cat.name() + "]");
//         categoryLabel.setPrefWidth(120);
//         categoryLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: #555555;");

//         amountLabel = new Label("$" + String.format("%.2f", amount));
//         amountLabel.setPrefWidth(80);
//         amountLabel.setTextAlignment(TextAlignment.RIGHT);

//         this.getChildren().addAll(index, expenseName, categoryLabel, amountLabel);
//     }
// }

// class ExpenseList extends VBox {

//     ExpenseList() {
//         this.setSpacing(5);
//         this.setPrefSize(500, 560);
//         this.setStyle("-fx-background-color: #FFFFFF;");
//         prePopulateData();
//     }

//     // Pre-populate with hardcoded data as requested
//     private void prePopulateData() {
//         this.getChildren().addAll(
//             new Expense(1,"Groceries", Category.FOOD, 101.75),
//             new Expense(2, "Utilities", Category.UTILITIES, 80.50),
//             new Expense(3, "Gas", Category.TRANSPORT, 60.00),
//             new Expense(4, "Movie Tickets", Category.ENTERTAINMENT, 30.00),
//             new Expense(5, "Online Order", Category.OTHER, 45.25)
            
//         );
//     }
// }

// class Header extends HBox {
//     Header() {
//         this.setPrefSize(500, 80);
//         this.setStyle("-fx-background-color: #FFFFFF;");

//         VBox container = new VBox();
//         Text titleText = new Text("Spending Tracker");
//         titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 24;");
        
        
//         container.getChildren().addAll(titleText);
//         container.setAlignment(Pos.CENTER);
        
//         this.getChildren().add(container);
//         this.setAlignment(Pos.CENTER);
//     }
// }

// class AppFrame extends BorderPane {

//     private Header header;
//     private ExpenseList expenseList;

//     AppFrame() {
//         header = new Header();
//         expenseList = new ExpenseList();

//         ScrollPane scroller = new ScrollPane(expenseList);
//         scroller.setFitToWidth(true);
//         scroller.setFitToHeight(true);
        
//         // 1. Remove the default ScrollPane border to make it blend in
//         scroller.setStyle("-fx-background-color: transparent; -fx-viewport-fill: #FFFFFF; -fx-background: #FFFFFF; -fx-border-color: transparent;");

//         // 2. Set the background of the entire frame to match your theme
//         this.setStyle("-fx-background-color: #FFFFFF;");

//         // 3. Use Padding instead of Margin to keep the color consistent
//         // Insets(Top, Right, Bottom, Left)
//         this.setPadding(new Insets(0, 25, 0, 25)); 

//         this.setTop(header);
//         this.setCenter(scroller);
        
//         HBox emptyFooter = new HBox();
//         emptyFooter.setPrefHeight(30);
//         this.setBottom(emptyFooter);
//     }
// }
// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         AppFrame root = new AppFrame();

//         primaryStage.setTitle("Spending Tracker");
//         primaryStage.setScene(new Scene(root, 500, 600));
//         primaryStage.setResizable(false);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }