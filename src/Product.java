
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class Product {
//     private Connection conn;

//     public Product(Connection conn) {
//         this.conn = conn;
//     }

//     // public void addProduct(String name, double price, int stock) {
//     // String query = "INSERT INTO Produk (nama_produk, harga, stok) VALUES (?, ?,
//     // ?)";
//     // try (PreparedStatement stmt = conn.prepareStatement(query)) {
//     // stmt.setString(1, name);
//     // stmt.setDouble(2, price);
//     // stmt.setInt(3, stock);
//     // stmt.executeUpdate();
//     // } catch (SQLException e) {
//     // e.printStackTrace();
//     // }
//     // }

//     public void addProduct(String name, double price, int stock) {
//         String query = "INSERT INTO Produk (nama_produk, harga, stok) VALUES (?, ?, ?)";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setDouble(2, price);
//             stmt.setInt(3, stock);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void updateProduct(int id, String name, double price, int stock) {
//         String query = "UPDATE Produk SET nama_produk = ?, harga = ?, stok = ? WHERE id_produk = ?";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setDouble(2, price);
//             stmt.setInt(3, stock);
//             stmt.setInt(4, id);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void deleteProduct(int id) {
//         String query = "DELETE FROM Produk WHERE id_produk = ?";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setInt(1, id);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void displayProducts() {
//         String query = "SELECT * FROM Produk";
//         try (Statement stmt = conn.createStatement();
//                 ResultSet rs = stmt.executeQuery(query)) {
//             while (rs.next()) {
//                 System.out.println("ID: " + rs.getInt("id_produk"));
//                 System.out.println("Name: " + rs.getString("nama_produk"));
//                 System.out.println("Price: " + rs.getDouble("harga"));
//                 System.out.println("Stock: " + rs.getInt("stok"));
//                 System.out.println("-----");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Implementasi metode updateProduct, deleteProduct, displayProducts seperti di
//     // atas
// }

//update tgl 31 agustus 2024
// public class Product {
//     private int id;
//     private String name;
//     private String category;
//     private double price;
//     private int stock;
//     private String expiryDate;

//     public Product(int id, String name, String category, double price, int stock, String expiryDate) {
//         this.id = id;
//         this.name = name;
//         this.category = category;
//         this.price = price;
//         this.stock = stock;
//         this.expiryDate = expiryDate;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getCategory() {
//         return category;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public int getStock() {
//         return stock;
//     }

//     public String getExpiryDate() {
//         return expiryDate;
//     }
// }

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private String expiryDate;

    public Product(int id, String name, String category, double price, int stock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
