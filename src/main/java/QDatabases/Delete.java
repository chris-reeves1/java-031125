package QDatabases;
import java.sql.*;
import java.util.*;

public class Delete {
    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            seed(conn);
            List<Customer> londoners = selectByCity(conn, "London");
            londoners.forEach(System.out::println);
            long id = findCustomerByName(conn, "Alice");
            System.out.println("Before: " + selectById(conn, id));
            updateCity(conn, id, "Berlin");
            System.out.println("After : " + selectById(conn, id));
            System.out.println("Count before: " + count(conn));
            deleteById(conn, id);
            System.out.println("Count after : " + count(conn));
        }
    }

    static List<Customer> selectByCity(Connection conn, String city) throws SQLException {
        String sql = "SELECT id, name, city FROM customers WHERE city = ? ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, city);
            try (ResultSet rs = ps.executeQuery()) {
                List<Customer> out = new ArrayList<>();
                while (rs.next()) out.add(mapRow(rs));
                return out;
            }
        }
    }

    // minimal helpers
    static void seed(Connection conn) throws SQLException {
        createTable(conn);
        insertCustomer(conn, "Alice", "London");
        insertCustomer(conn, "Bob", "Paris");
        insertCustomer(conn, "Charlie", "London");
    }
    static void createTable(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("""
                CREATE TABLE IF NOT EXISTS customers(
                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                  name VARCHAR(100) NOT NULL,
                  city VARCHAR(100) NOT NULL
                )
            """);
        }
    }
    static long insertCustomer(Connection conn, String name, String city) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO customers(name, city) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name); ps.setString(2, city); ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) { if (keys.next()) return keys.getLong(1); }
        }
        throw new SQLException("No key");
    }
    static Customer mapRow(ResultSet rs) throws SQLException {
        return new Customer(rs.getLong("id"), rs.getString("name"), rs.getString("city"));
    }
    static class Customer { final long id; final String name; final String city;
        Customer(long id,String name,String city){this.id=id;this.name=name;this.city=city;}
        public String toString(){return "Customer{id=%d, name='%s', city='%s'}".formatted(id,name,city);}
    }
     static String selectById(Connection conn, long id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id,name,city FROM customers WHERE id=?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? "Customer{id=%d, name='%s', city='%s'}"
                        .formatted(rs.getLong(1), rs.getString(2), rs.getString(3))
                        : null;
            }
        }
}
    static int updateCity(Connection conn, long id, String newCity) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE customers SET city=? WHERE id=?")) {
            ps.setString(1, newCity);
            ps.setLong(2, id);
            return ps.executeUpdate();
        }
    }
    static long findCustomerByName(Connection conn, String name) throws SQLException {
    String sql = "SELECT id FROM customers WHERE name = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, name);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong("id");
            }
        }
    }
    throw new SQLException("Customer with name " + name + " not found.");
}
     static int deleteById(Connection conn, long id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE id=?")) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }
    static long count(Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM customers");
             ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getLong(1); }
    }
}