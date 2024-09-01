
// // Contoh tampilan GUI menggunakan JavaFX
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TableView;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class MainApp extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Sales Inventory Management");

//         // Create UI components
//         TextField productNameField = new TextField();
//         TextField productPriceField = new TextField();
//         TextField productStockField = new TextField();
//         Button addButton = new Button("Add Product");
//         TableView<Product> productTable = new TableView<>();

//         // Layout
//         VBox vbox = new VBox();
//         vbox.getChildren().addAll(productNameField, productPriceField, productStockField, addButton, productTable);

//         // Add Button Event Handler
//         addButton.setOnAction(e -> {
//             // Add product logic here
//         });

//         // Set Scene and Stage
//         Scene scene = new Scene(vbox, 600, 400);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TableView;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import java.sql.Connection;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;

// public class MainApp extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Sales Inventory Management");

//         // Create UI components
//         TextField productNameField = new TextField();
//         TextField productPriceField = new TextField();
//         TextField productStockField = new TextField();
//         Button addButton = new Button("Add Product");
//         TableView<Product> productTable = new TableView<>();
//         Label errorLabel = new Label(); // Label to display error messages

//         // Layout
//         VBox vbox = new VBox();
//         vbox.getChildren().addAll(productNameField, productPriceField, productStockField, addButton, errorLabel,
//                 productTable);

//         // Add Button Event Handler
//         addButton.setOnAction(e -> {
//             String name = productNameField.getText().trim();
//             String priceText = productPriceField.getText().trim();
//             String stockText = productStockField.getText().trim();
//             errorLabel.setText(""); // Clear previous errors

//             try {
//                 double price = Double.parseDouble(priceText);
//                 int stock = Integer.parseInt(stockText);
//                 addProduct(name, price, stock);
//                 productTable.getItems().setAll(loadProducts()); // Update table view after adding
//             } catch (NumberFormatException ex) {
//                 errorLabel.setText("Invalid input: Price and Stock must be numeric values.");
//             } catch (Exception ex) {
//                 errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
//             }
//         });

//         // Set Scene and Stage
//         Scene scene = new Scene(vbox, 600, 400);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void addProduct(String name, double price, int stock) {
//         try (Connection conn = Database.connect();
//                 Statement stmt = conn.createStatement()) {
//             String query = "INSERT INTO Produk (nama_produk, harga, stok) VALUES ('" + name + "', " + price + ", "
//                     + stock + ")";
//             stmt.executeUpdate(query);
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     private List<Product> loadProducts() {
//         List<Product> products = new ArrayList<>();
//         try (Connection conn = Database.connect();
//                 Statement stmt = conn.createStatement();
//                 ResultSet rs = stmt.executeQuery("SELECT * FROM Produk")) {
//             while (rs.next()) {
//                 int id = rs.getInt("id_produk");
//                 String name = rs.getString("nama_produk");
//                 double price = rs.getDouble("harga");
//                 int stock = rs.getInt("stok");
//                 products.add(new Product(id, name, price, stock)); // Use constructor that takes 4 parameters
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return products;
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

//update tgl 31 agustus 2024
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// public class MainApp extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Sales Inventory Management");

//         TextField productNameField = new TextField();
//         TextField productCategoryField = new TextField();
//         TextField productPriceField = new TextField();
//         TextField productStockField = new TextField();
//         TextField productExpiryDateField = new TextField();
//         TextField productIdField = new TextField();

//         productNameField.setPromptText("Product Name");
//         productCategoryField.setPromptText("Category");
//         productPriceField.setPromptText("Price");
//         productStockField.setPromptText("Stock");
//         productExpiryDateField.setPromptText("Expiry Date (YYYY-MM-DD)");
//         productIdField.setPromptText("Product ID");

//         Button addButton = new Button("Add Product");
//         Button updateButton = new Button("Update Product");
//         Button deleteButton = new Button("Delete Product");
//         Button viewButton = new Button("View Products");

//         TableView<Product> productTable = new TableView<>();
//         TableColumn<Product, Integer> idColumn = new TableColumn<>("ID");
//         idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//         TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
//         nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//         TableColumn<Product, String> categoryColumn = new TableColumn<>("Category");
//         categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//         TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
//         priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//         TableColumn<Product, Integer> stockColumn = new TableColumn<>("Stock");
//         stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//         TableColumn<Product, String> expiryDateColumn = new TableColumn<>("Expiry Date");
//         expiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));

//         productTable.getColumns().addAll(idColumn, nameColumn, categoryColumn, priceColumn, stockColumn,
//                 expiryDateColumn);

//         Label errorLabel = new Label();

//         VBox vbox = new VBox();
//         vbox.getChildren().addAll(productNameField, productCategoryField, productPriceField, productStockField,
//                 productExpiryDateField, productIdField, addButton, updateButton, deleteButton, viewButton, errorLabel,
//                 productTable);

//         addButton.setOnAction(e -> {
//             String name = productNameField.getText().trim();
//             String category = productCategoryField.getText().trim();
//             String priceText = productPriceField.getText().trim();
//             String stockText = productStockField.getText().trim();
//             String expiryDate = productExpiryDateField.getText().trim();
//             errorLabel.setText("");

//             try {
//                 double price = Double.parseDouble(priceText);
//                 int stock = Integer.parseInt(stockText);

//                 addProduct(name, category, price, stock, expiryDate);
//                 productTable.getItems().setAll(loadProducts()); // Refresh table
//             } catch (NumberFormatException ex) {
//                 errorLabel.setText("Invalid input: Price and Stock must be numeric values.");
//             } catch (SQLException ex) {
//                 errorLabel.setText("Database error: " + ex.getMessage());
//             } catch (Exception ex) {
//                 errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
//             }
//         });

//         updateButton.setOnAction(e -> {
//             String idText = productIdField.getText().trim();
//             String name = productNameField.getText().trim();
//             String category = productCategoryField.getText().trim();
//             String priceText = productPriceField.getText().trim();
//             String stockText = productStockField.getText().trim();
//             String expiryDate = productExpiryDateField.getText().trim();
//             errorLabel.setText("");

//             try {
//                 int id = Integer.parseInt(idText);
//                 double price = Double.parseDouble(priceText);
//                 int stock = Integer.parseInt(stockText);

//                 updateProduct(id, name, category, price, stock, expiryDate);
//                 productTable.getItems().setAll(loadProducts()); // Refresh table
//             } catch (NumberFormatException ex) {
//                 errorLabel.setText("Invalid input: ID, Price, and Stock must be numeric values.");
//             } catch (SQLException ex) {
//                 errorLabel.setText("Database error: " + ex.getMessage());
//             } catch (Exception ex) {
//                 errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
//             }
//         });

//         deleteButton.setOnAction(e -> {
//             String idText = productIdField.getText().trim();
//             errorLabel.setText("");

//             try {
//                 int id = Integer.parseInt(idText);

//                 deleteProduct(id);
//                 productTable.getItems().setAll(loadProducts()); // Refresh table
//             } catch (NumberFormatException ex) {
//                 errorLabel.setText("Invalid input: ID must be a numeric value.");
//             } catch (SQLException ex) {
//                 errorLabel.setText("Database error: " + ex.getMessage());
//             } catch (Exception ex) {
//                 errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
//             }
//         });

//         viewButton.setOnAction(e -> productTable.getItems().setAll(loadProducts()));

//         Scene scene = new Scene(vbox, 800, 600);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void addProduct(String name, String category, double price, int stock, String expiryDate)
//             throws SQLException {
//         String query = "INSERT INTO Produk (nama_produk, kategori, harga, stok, tanggal_kadaluarsa) VALUES (?, ?, ?, ?, ?)";

//         try (Connection conn = Database.connect();
//                 PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setString(2, category);
//             stmt.setDouble(3, price);
//             stmt.setInt(4, stock);
//             stmt.setString(5, expiryDate);
//             stmt.executeUpdate();
//         }
//     }

//     private void updateProduct(int id, String name, String category, double price, int stock, String expiryDate)
//             throws SQLException {
//         String query = "UPDATE Produk SET nama_produk = ?, kategori = ?, harga = ?, stok = ?, tanggal_kadaluarsa = ? WHERE id_produk = ?";

//         try (Connection conn = Database.connect();
//                 PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setString(2, category);
//             stmt.setDouble(3, price);
//             stmt.setInt(4, stock);
//             stmt.setString(5, expiryDate);
//             stmt.setInt(6, id);
//             int rowsAffected = stmt.executeUpdate();
//             if (rowsAffected == 0) {
//                 throw new SQLException("No product found with ID: " + id);
//             }
//         }
//     }

//     private void deleteProduct(int id) throws SQLException {
//         String query = "DELETE FROM Produk WHERE id_produk = ?";

//         try (Connection conn = Database.connect();
//                 PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setInt(1, id);
//             int rowsAffected = stmt.executeUpdate();
//             if (rowsAffected == 0) {
//                 throw new SQLException("No product found with ID: " + id);
//             }
//         }
//     }

//     private List<Product> loadProducts() {
//         List<Product> products = new ArrayList<>();
//         String query = "SELECT * FROM Produk";

//         try (Connection conn = Database.connect();
//                 PreparedStatement stmt = conn.prepareStatement(query);
//                 ResultSet rs = stmt.executeQuery()) {

//             while (rs.next()) {
//                 int id = rs.getInt("id_produk");
//                 String name = rs.getString("nama_produk");
//                 String category = rs.getString("kategori");
//                 double price = rs.getDouble("harga");
//                 int stock = rs.getInt("stok");
//                 String expiryDate = rs.getString("tanggal_kadaluarsa");
//                 products.add(new Product(id, name, category, price, stock, expiryDate));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }

//         return products;
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    private TabPane tabPane;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sales Inventory Management");

        tabPane = new TabPane();

        Tab productTab = new Tab("Manage Products");
        VBox productVBox = createProductManagementUI();
        productTab.setContent(productVBox);

        Tab customerTab = new Tab("Manage Customers");
        VBox customerVBox = createCustomerManagementUI();
        customerTab.setContent(customerVBox);

        Tab transactionTab = new Tab("Manage Transactions");
        VBox transactionVBox = createTransactionManagementUI();
        transactionTab.setContent(transactionVBox);

        Tab productSearchTab = new Tab("Product Search");
        VBox productSearchVBox = createProductSearchUI();
        productSearchTab.setContent(productSearchVBox);

        Tab salesReportTab = new Tab("Sales Report by Category");
        VBox salesReportVBox = createSalesReportUI();
        salesReportTab.setContent(salesReportVBox);

        Tab customerSearchTab = new Tab("Customer Search");
        VBox customerSearchVBox = createCustomerSearchUI();
        customerSearchTab.setContent(customerSearchVBox);

        Tab lowStockReportTab = new Tab("Low Stock Report");
        VBox lowStockReportVBox = createLowStockReportUI();
        lowStockReportTab.setContent(lowStockReportVBox);

        tabPane.getTabs().addAll(productTab, customerTab, transactionTab, productSearchTab, salesReportTab,
                customerSearchTab, lowStockReportTab);
        tabPane.setVisible(false);

        Button productButton = new Button("PRODUCT");
        Button customerButton = new Button("CUSTOMER");
        Button salesTransactionButton = new Button("SALES TRANSACTION");
        Button productSearchButton = new Button("PRODUCT SEARCH");
        Button salesReportButton = new Button("SALES REPORT BY CATEGORY");
        Button customerSearchButton = new Button("CUSTOMER SEARCH");
        Button lowStockReportButton = new Button("LOW STOCK REPORT");

        productButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-font-size: 18px;");
        customerButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-font-size: 18px;");
        salesTransactionButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-font-size: 18px;");
        productSearchButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-font-size: 18px;");
        salesReportButton.setStyle("-fx-background-color: #D65A31; -fx-text-fill: white; -fx-font-size: 18px;");
        customerSearchButton.setStyle("-fx-background-color: #D65A31; -fx-text-fill: white; -fx-font-size: 18px;");
        lowStockReportButton.setStyle("-fx-background-color: #D65A31; -fx-text-fill: white; -fx-font-size: 18px;");

        productButton.setPrefSize(200, 200);
        customerButton.setPrefSize(200, 200);
        salesTransactionButton.setPrefSize(200, 200);
        productSearchButton.setPrefSize(200, 200);
        salesReportButton.setPrefSize(200, 200);
        customerSearchButton.setPrefSize(200, 200);
        lowStockReportButton.setPrefSize(200, 200);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(productButton, 0, 0);
        gridPane.add(customerButton, 1, 0);
        gridPane.add(salesTransactionButton, 2, 0);
        gridPane.add(productSearchButton, 0, 1);
        gridPane.add(salesReportButton, 1, 1);
        gridPane.add(customerSearchButton, 2, 1);
        gridPane.add(lowStockReportButton, 1, 2); // Add the Low Stock Report button

        VBox mainVBox = new VBox(20);
        mainVBox.getChildren().addAll(gridPane, tabPane);
        mainVBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainVBox, 900, 600);

        productButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(productTab);
            tabPane.setVisible(true);
        });

        customerButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(customerTab);
            tabPane.setVisible(true);
        });

        salesTransactionButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(transactionTab);
            tabPane.setVisible(true);
        });

        productSearchButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(productSearchTab);
            tabPane.setVisible(true);
        });

        salesReportButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(salesReportTab);
            tabPane.setVisible(true);
        });

        customerSearchButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(customerSearchTab);
            tabPane.setVisible(true);
        });

        lowStockReportButton.setOnAction(e -> {
            tabPane.getSelectionModel().select(lowStockReportTab);
            tabPane.setVisible(true);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createProductManagementUI() {
        TextField productNameField = new TextField();
        TextField productCategoryField = new TextField();
        TextField productPriceField = new TextField();
        TextField productStockField = new TextField();
        TextField productExpiryDateField = new TextField();
        TextField productIdField = new TextField();

        productNameField.setPromptText("Product Name");
        productCategoryField.setPromptText("Category");
        productPriceField.setPromptText("Price");
        productStockField.setPromptText("Stock");
        productExpiryDateField.setPromptText("Expiry Date (YYYY-MM-DD)");
        productIdField.setPromptText("Product ID");

        Button addButton = new Button("Add Product");
        Button updateButton = new Button("Update Product");
        Button deleteButton = new Button("Delete Product");
        Button viewButton = new Button("View Products");

        TableView<Product> productTable = new TableView<>();
        TableColumn<Product, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, Integer> stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        TableColumn<Product, String> expiryDateColumn = new TableColumn<>("Expiry Date");
        expiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));

        productTable.getColumns().addAll(idColumn, nameColumn, categoryColumn, priceColumn, stockColumn,
                expiryDateColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(productNameField, productCategoryField, productPriceField, productStockField,
                productExpiryDateField, productIdField, addButton, updateButton, deleteButton, viewButton, errorLabel,
                productTable);

        addButton.setOnAction(e -> {
            String name = productNameField.getText().trim();
            String category = productCategoryField.getText().trim();
            String priceText = productPriceField.getText().trim();
            String stockText = productStockField.getText().trim();
            String expiryDate = productExpiryDateField.getText().trim();
            errorLabel.setText("");

            try {
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);

                addProduct(name, category, price, stock, expiryDate);
                productTable.getItems().setAll(loadProducts());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: Price and Stock must be numeric values.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        updateButton.setOnAction(e -> {
            String idText = productIdField.getText().trim();
            String name = productNameField.getText().trim();
            String category = productCategoryField.getText().trim();
            String priceText = productPriceField.getText().trim();
            String stockText = productStockField.getText().trim();
            String expiryDate = productExpiryDateField.getText().trim();
            errorLabel.setText("");

            try {
                int id = Integer.parseInt(idText);
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);

                updateProduct(id, name, category, price, stock, expiryDate);
                productTable.getItems().setAll(loadProducts());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: ID, Price, and Stock must be numeric values.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        deleteButton.setOnAction(e -> {
            String idText = productIdField.getText().trim();
            errorLabel.setText("");

            try {
                int id = Integer.parseInt(idText);

                deleteProduct(id);
                productTable.getItems().setAll(loadProducts());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: ID must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        viewButton.setOnAction(e -> {
            try {
                productTable.getItems().setAll(loadProducts());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        return vbox;
    }

    private VBox createCustomerManagementUI() {
        TextField customerNameField = new TextField();
        TextField customerAddressField = new TextField();
        TextField customerPhoneField = new TextField();
        TextField customerEmailField = new TextField();
        TextField customerMembershipStatusField = new TextField();
        TextField customerIdField = new TextField();

        customerNameField.setPromptText("Customer Name");
        customerAddressField.setPromptText("Address");
        customerPhoneField.setPromptText("Phone");
        customerEmailField.setPromptText("Email");
        customerMembershipStatusField.setPromptText("Membership Status");
        customerIdField.setPromptText("Customer ID");

        Button addCustomerButton = new Button("Add Customer");
        Button updateCustomerButton = new Button("Update Customer");
        Button deleteCustomerButton = new Button("Delete Customer");
        Button viewCustomerButton = new Button("View Customers");

        TableView<Customer> customerTable = new TableView<>();
        TableColumn<Customer, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Customer, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Customer, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Customer, String> membershipStatusColumn = new TableColumn<>("Membership Status");
        membershipStatusColumn.setCellValueFactory(new PropertyValueFactory<>("membershipStatus"));

        customerTable.getColumns().addAll(idColumn, nameColumn, addressColumn, phoneColumn, emailColumn,
                membershipStatusColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(customerNameField, customerAddressField, customerPhoneField, customerEmailField,
                customerMembershipStatusField, customerIdField, addCustomerButton, updateCustomerButton,
                deleteCustomerButton, viewCustomerButton, errorLabel, customerTable);

        addCustomerButton.setOnAction(e -> {
            String name = customerNameField.getText().trim();
            String address = customerAddressField.getText().trim();
            String phone = customerPhoneField.getText().trim();
            String email = customerEmailField.getText().trim();
            String membershipStatus = customerMembershipStatusField.getText().trim();
            errorLabel.setText("");

            try {
                addCustomer(name, address, phone, email, membershipStatus);
                customerTable.getItems().setAll(loadCustomers());
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        updateCustomerButton.setOnAction(e -> {
            String idText = customerIdField.getText().trim();
            String name = customerNameField.getText().trim();
            String address = customerAddressField.getText().trim();
            String phone = customerPhoneField.getText().trim();
            String email = customerEmailField.getText().trim();
            String membershipStatus = customerMembershipStatusField.getText().trim();
            errorLabel.setText("");

            try {
                int id = Integer.parseInt(idText);

                updateCustomer(id, name, address, phone, email, membershipStatus);
                customerTable.getItems().setAll(loadCustomers());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: ID must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        deleteCustomerButton.setOnAction(e -> {
            String idText = customerIdField.getText().trim();
            errorLabel.setText("");

            try {
                int id = Integer.parseInt(idText);

                deleteCustomer(id);
                customerTable.getItems().setAll(loadCustomers());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: ID must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        viewCustomerButton.setOnAction(e -> {
            try {
                customerTable.getItems().setAll(loadCustomers());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        return vbox;
    }

    private VBox createTransactionManagementUI() {
        TextField customerIdField = new TextField();
        TextField transactionDateField = new TextField();
        TextField totalAmountField = new TextField();
        TextField discountField = new TextField();
        TextField transactionIdField = new TextField();

        customerIdField.setPromptText("Customer ID");
        transactionDateField.setPromptText("Transaction Date (YYYY-MM-DD)");
        totalAmountField.setPromptText("Total Amount");
        discountField.setPromptText("Discount");
        transactionIdField.setPromptText("Transaction ID");

        Button addTransactionButton = new Button("Add Transaction");
        Button updateTransactionButton = new Button("Update Transaction");
        Button deleteTransactionButton = new Button("Delete Transaction");
        Button viewTransactionButton = new Button("View Transactions");

        TableView<Transaction> transactionTable = new TableView<>();
        TableColumn<Transaction, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Transaction, Integer> customerIdColumn = new TableColumn<>("Customer ID");
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        TableColumn<Transaction, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Transaction, Double> totalAmountColumn = new TableColumn<>("Total Amount");
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        TableColumn<Transaction, Double> discountColumn = new TableColumn<>("Discount");
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));

        transactionTable.getColumns().addAll(idColumn, customerIdColumn, dateColumn, totalAmountColumn, discountColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(customerIdField, transactionDateField, totalAmountField, discountField,
                transactionIdField, addTransactionButton, updateTransactionButton, deleteTransactionButton,
                viewTransactionButton, errorLabel, transactionTable);

        addTransactionButton.setOnAction(e -> {
            String customerIdText = customerIdField.getText().trim();
            String date = transactionDateField.getText().trim();
            String totalAmountText = totalAmountField.getText().trim();
            String discountText = discountField.getText().trim();
            errorLabel.setText("");

            try (Connection conn = Database.connect()) {
                conn.setAutoCommit(false); // Start transaction

                int customerId = Integer.parseInt(customerIdText);
                double totalAmount = Double.parseDouble(totalAmountText);
                double discount = Double.parseDouble(discountText);

                addTransaction(conn, customerId, date, totalAmount, discount);
                conn.commit(); // Commit transaction if all goes well

                transactionTable.getItems().setAll(loadTransactions());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: Customer ID, Total Amount, and Discount must be numeric values.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        updateTransactionButton.setOnAction(e -> {
            String transactionIdText = transactionIdField.getText().trim();
            String customerIdText = customerIdField.getText().trim();
            String date = transactionDateField.getText().trim();
            String totalAmountText = totalAmountField.getText().trim();
            String discountText = discountField.getText().trim();
            errorLabel.setText("");

            try {
                int transactionId = Integer.parseInt(transactionIdText);
                int customerId = Integer.parseInt(customerIdText);
                double totalAmount = Double.parseDouble(totalAmountText);
                double discount = Double.parseDouble(discountText);

                updateTransaction(transactionId, customerId, date, totalAmount, discount);
                transactionTable.getItems().setAll(loadTransactions());
            } catch (NumberFormatException ex) {
                errorLabel
                        .setText("Invalid input: ID, Customer ID, Total Amount, and Discount must be numeric values.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        deleteTransactionButton.setOnAction(e -> {
            String transactionIdText = transactionIdField.getText().trim();
            errorLabel.setText("");

            try {
                int transactionId = Integer.parseInt(transactionIdText);

                deleteTransaction(transactionId);
                transactionTable.getItems().setAll(loadTransactions());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: ID must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        viewTransactionButton.setOnAction(e -> {
            try {
                transactionTable.getItems().setAll(loadTransactions());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        return vbox;
    }

    private VBox createProductSearchUI() {
        TextField categoryField = new TextField();
        TextField minPriceField = new TextField();
        TextField maxPriceField = new TextField();

        categoryField.setPromptText("Category");
        minPriceField.setPromptText("Min Price");
        maxPriceField.setPromptText("Max Price");

        Button searchButton = new Button("Search");

        TableView<Product> productTable = new TableView<>();
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, Integer> stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        productTable.getColumns().addAll(nameColumn, categoryColumn, priceColumn, stockColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(categoryField, minPriceField, maxPriceField, searchButton, errorLabel, productTable);

        searchButton.setOnAction(e -> {
            String category = categoryField.getText().trim();
            String minPriceText = minPriceField.getText().trim();
            String maxPriceText = maxPriceField.getText().trim();
            errorLabel.setText("");

            try {
                double minPrice = Double.parseDouble(minPriceText);
                double maxPrice = Double.parseDouble(maxPriceText);

                productTable.getItems().setAll(searchProducts(category, minPrice, maxPrice));
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: Min Price and Max Price must be numeric values.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        return vbox;
    }

    private VBox createSalesReportUI() {
        TableView<SalesReport> reportTable = new TableView<>();
        TableColumn<SalesReport, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<SalesReport, Double> totalSalesColumn = new TableColumn<>("Total Sales");
        totalSalesColumn.setCellValueFactory(new PropertyValueFactory<>("totalSales"));

        reportTable.getColumns().addAll(categoryColumn, totalSalesColumn);

        Button viewReportButton = new Button("View Report");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(viewReportButton, reportTable);

        viewReportButton.setOnAction(e -> {
            try {
                reportTable.getItems().setAll(loadSalesReport());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        return vbox;
    }

    private VBox createLowStockReportUI() {
        TextField stockThresholdField = new TextField();
        stockThresholdField.setPromptText("Stock Threshold");

        Button generateReportButton = new Button("Generate Report");

        TableView<Product> lowStockTable = new TableView<>();
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Product, Integer> stockColumn = new TableColumn<>("Stock Quantity");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        lowStockTable.getColumns().addAll(nameColumn, categoryColumn, stockColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(stockThresholdField, generateReportButton, errorLabel, lowStockTable);

        generateReportButton.setOnAction(e -> {
            String thresholdText = stockThresholdField.getText().trim();
            errorLabel.setText("");

            try {
                int threshold = Integer.parseInt(thresholdText);
                lowStockTable.getItems().setAll(loadLowStockProducts(threshold));
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: Stock Threshold must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        return vbox;
    }

    private VBox createCustomerSearchUI() {
        TextField locationField = new TextField();
        TextField minTransactionAmountField = new TextField();

        locationField.setPromptText("Location");
        minTransactionAmountField.setPromptText("Min Transaction Amount");

        Button searchButton = new Button("Search");

        TableView<Customer> customerTable = new TableView<>();
        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Customer, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Customer, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Customer, String> membershipStatusColumn = new TableColumn<>("Membership Status");
        membershipStatusColumn.setCellValueFactory(new PropertyValueFactory<>("membershipStatus"));

        customerTable.getColumns().addAll(nameColumn, addressColumn, phoneColumn, emailColumn, membershipStatusColumn);

        Label errorLabel = new Label();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(locationField, minTransactionAmountField, searchButton, errorLabel, customerTable);

        searchButton.setOnAction(e -> {
            String location = locationField.getText().trim();
            String minTransactionAmountText = minTransactionAmountField.getText().trim();
            errorLabel.setText("");

            try {
                double minTransactionAmount = Double.parseDouble(minTransactionAmountText);

                customerTable.getItems().setAll(searchCustomers(location, minTransactionAmount));
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input: Min Transaction Amount must be a numeric value.");
            } catch (SQLException ex) {
                errorLabel.setText("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("An unexpected error occurred: " + ex.getMessage());
            }
        });

        return vbox;
    }

    private void addProduct(String name, String category, double price, int stock, String expiryDate)
            throws SQLException {
        String query = "INSERT INTO Produk (nama_produk, kategori, harga, stok, tanggal_kadaluarsa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setDouble(3, price);
            stmt.setInt(4, stock);
            stmt.setString(5, expiryDate);
            stmt.executeUpdate();
        }
    }

    private void updateProduct(int id, String name, String category, double price, int stock, String expiryDate)
            throws SQLException {
        String query = "UPDATE Produk SET nama_produk = ?, kategori = ?, harga = ?, stok = ?, tanggal_kadaluarsa = ? WHERE id_produk = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setDouble(3, price);
            stmt.setInt(4, stock);
            stmt.setString(5, expiryDate);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }

    private void deleteProduct(int id) throws SQLException {
        String query = "DELETE FROM Produk WHERE id_produk = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private List<Product> loadProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Produk";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_produk");
                String name = rs.getString("nama_produk");
                String category = rs.getString("kategori");
                double price = rs.getDouble("harga");
                int stock = rs.getInt("stok");
                String expiryDate = rs.getString("tanggal_kadaluarsa");
                products.add(new Product(id, name, category, price, stock, expiryDate));
            }
        }

        return products;
    }

    private List<Product> loadLowStockProducts(int threshold) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Produk WHERE stok <= ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, threshold);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_produk");
                String name = rs.getString("nama_produk");
                String category = rs.getString("kategori");
                double price = rs.getDouble("harga");
                int stock = rs.getInt("stok");
                String expiryDate = rs.getString("tanggal_kadaluarsa");
                products.add(new Product(id, name, category, price, stock, expiryDate));
            }
        }

        return products;
    }

    private void addCustomer(String name, String address, String phone, String email, String membershipStatus)
            throws SQLException {
        String query = "INSERT INTO Pelanggan (nama_pelanggan, alamat, no_telepon, email, status_keanggotaan) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setString(5, membershipStatus);
            stmt.executeUpdate();
        }
    }

    private void updateCustomer(int id, String name, String address, String phone, String email,
            String membershipStatus) throws SQLException {
        String query = "UPDATE Pelanggan SET nama_pelanggan = ?, alamat = ?, no_telepon = ?, email = ?, status_keanggotaan = ? WHERE id_pelanggan = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setString(5, membershipStatus);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }

    private void deleteCustomer(int id) throws SQLException {
        String query = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private List<Customer> loadCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Pelanggan";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_pelanggan");
                String name = rs.getString("nama_pelanggan");
                String address = rs.getString("alamat");
                String phone = rs.getString("no_telepon");
                String email = rs.getString("email");
                String membershipStatus = rs.getString("status_keanggotaan");
                customers.add(new Customer(id, name, address, phone, email, membershipStatus));
            }
        }

        return customers;
    }

    private void addTransaction(Connection conn, int customerId, String date, double totalAmount, double discount)
            throws SQLException {
        String query = "INSERT INTO Transaksi (id_pelanggan, tanggal_transaksi, total_harga, diskon) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setString(2, date);
            stmt.setDouble(3, totalAmount);
            stmt.setDouble(4, discount);
            stmt.executeUpdate();
        }
    }

    private void updateTransaction(int id, int customerId, String date, double totalAmount, double discount)
            throws SQLException {
        String query = "UPDATE Transaksi SET id_pelanggan = ?, tanggal_transaksi = ?, total_harga = ?, diskon = ? WHERE id_transaksi = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setString(2, date);
            stmt.setDouble(3, totalAmount);
            stmt.setDouble(4, discount);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    private void deleteTransaction(int id) throws SQLException {
        String query = "DELETE FROM Transaksi WHERE id_transaksi = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private List<Transaction> loadTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM Transaksi";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_transaksi");
                int customerId = rs.getInt("id_pelanggan");
                String date = rs.getString("tanggal_transaksi");
                double totalAmount = rs.getDouble("total_harga");
                double discount = rs.getDouble("diskon");
                transactions.add(new Transaction(id, customerId, date, totalAmount, discount));
            }
        }

        return transactions;
    }

    private List<Product> searchProducts(String category, double minPrice, double maxPrice) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Produk WHERE kategori = ? AND harga BETWEEN ? AND ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            stmt.setDouble(2, minPrice);
            stmt.setDouble(3, maxPrice);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_produk");
                String name = rs.getString("nama_produk");
                String cat = rs.getString("kategori");
                double price = rs.getDouble("harga");
                int stock = rs.getInt("stok");
                String expiryDate = rs.getString("tanggal_kadaluarsa");
                products.add(new Product(id, name, cat, price, stock, expiryDate));
            }
        }

        return products;
    }

    private List<SalesReport> loadSalesReport() throws SQLException {
        List<SalesReport> salesReports = new ArrayList<>();
        String query = "SELECT kategori, SUM(harga) as totalSales FROM Produk GROUP BY kategori";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String category = rs.getString("kategori");
                double totalSales = rs.getDouble("totalSales");
                salesReports.add(new SalesReport(category, totalSales));
            }
        }

        return salesReports;
    }

    private List<Customer> searchCustomers(String location, double minTransactionAmount) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT Pelanggan.* FROM Pelanggan " +
                "JOIN Transaksi ON Pelanggan.id_pelanggan = Transaksi.id_pelanggan " +
                "WHERE Pelanggan.alamat = ? AND Transaksi.total_harga >= ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, location);
            stmt.setDouble(2, minTransactionAmount);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_pelanggan");
                String name = rs.getString("nama_pelanggan");
                String address = rs.getString("alamat");
                String phone = rs.getString("no_telepon");
                String email = rs.getString("email");
                String membershipStatus = rs.getString("status_keanggotaan");
                customers.add(new Customer(id, name, address, phone, email, membershipStatus));
            }
        }

        return customers;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
