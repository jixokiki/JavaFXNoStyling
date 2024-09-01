//update tgl 31 agustus 2024
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// public class Customer {
//     private Connection conn;

//     public Customer(Connection conn) {
//         this.conn = conn;
//     }

//     public void addCustomer(String name, String address, String phone, String email, String membershipStatus)
//             throws SQLException {
//         String query = "INSERT INTO Pelanggan (nama_pelanggan, alamat, no_telepon, email, status_keanggotaan) VALUES (?, ?, ?, ?, ?)";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setString(2, address);
//             stmt.setString(3, phone);
//             stmt.setString(4, email);
//             stmt.setString(5, membershipStatus);
//             stmt.executeUpdate();
//         }
//     }

//     public void updateCustomer(int id, String name, String address, String phone, String email, String membershipStatus)
//             throws SQLException {
//         String query = "UPDATE Pelanggan SET nama_pelanggan = ?, alamat = ?, no_telepon = ?, email = ?, status_keanggotaan = ? WHERE id_pelanggan = ?";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, name);
//             stmt.setString(2, address);
//             stmt.setString(3, phone);
//             stmt.setString(4, email);
//             stmt.setString(5, membershipStatus);
//             stmt.setInt(6, id);
//             stmt.executeUpdate();
//         }
//     }

//     public void deleteCustomer(int id) throws SQLException {
//         String query = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setInt(1, id);
//             stmt.executeUpdate();
//         }
//     }

//     public ResultSet viewCustomer(int id) throws SQLException {
//         String query = "SELECT * FROM Pelanggan WHERE id_pelanggan = ?";
//         PreparedStatement stmt = conn.prepareStatement(query);
//         stmt.setInt(1, id);
//         return stmt.executeQuery();
//     }
// }

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String membershipStatus;

    public Customer(int id, String name, String address, String phone, String email, String membershipStatus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}
