// update tgl 31 agustus 2024
// import java.sql.Connection;
// import java.sql.Date;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// public class Transaction {
// private Connection conn;

// public Transaction(Connection conn) {
// this.conn = conn;
// }

// public void addTransaction(int productId, int customerId, Date date, double
// totalAmount, double discount)
// throws SQLException {
// String query = "INSERT INTO Transaksi (id_produk, id_pelanggan,
// tanggal_transaksi, total_harga, diskon) VALUES (?, ?, ?, ?, ?)";
// try (PreparedStatement stmt = conn.prepareStatement(query)) {
// stmt.setInt(1, productId);
// stmt.setInt(2, customerId);
// stmt.setDate(3, date);
// stmt.setDouble(4, totalAmount);
// stmt.setDouble(5, discount);
// stmt.executeUpdate();
// }
// }

// public void updateTransaction(int id, int productId, int customerId, Date
// date, double totalAmount, double discount)
// throws SQLException {
// String query = "UPDATE Transaksi SET id_produk = ?, id_pelanggan = ?,
// tanggal_transaksi = ?, total_harga = ?, diskon = ? WHERE id_transaksi = ?";
// try (PreparedStatement stmt = conn.prepareStatement(query)) {
// stmt.setInt(1, productId);
// stmt.setInt(2, customerId);
// stmt.setDate(3, date);
// stmt.setDouble(4, totalAmount);
// stmt.setDouble(5, discount);
// stmt.setInt(6, id);
// stmt.executeUpdate();
// }
// }

// public void deleteTransaction(int id) throws SQLException {
// String query = "DELETE FROM Transaksi WHERE id_transaksi = ?";
// try (PreparedStatement stmt = conn.prepareStatement(query)) {
// stmt.setInt(1, id);
// stmt.executeUpdate();
// }
// }
// }

public class Transaction {
    private int id;
    private int customerId;
    private String date;
    private double totalAmount;
    private double discount;

    public Transaction(int id, int customerId, String date, double totalAmount, double discount) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }

    // Add getters and setters here if needed

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
