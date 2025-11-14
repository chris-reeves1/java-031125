package QDatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Selecting {
private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
private static final String USER = "sa";
private static final String PASS = "";

public static void main(String[] args) throws Exception {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            createTable(conn);

            insertCustomer(conn, "a" , "londin");
            insertCustomer(conn, "b", "tokyo");
            insertCustomer(conn, "c" , "madrid");

            for (Customer c : selectAll(conn)){
                System.out.println(c);
            }

            }   
}

static void createTable(Connection conn) throws SQLException{
        try (Statement st = conn.createStatement()){
            st.execute("""
                    CREATE TABLE IF NOT EXISTS customers (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    city VARCHAR(100) NOT NULL
                    )      
                        """);
        }
    }

    static long insertCustomer(Connection conn, String name, String city) throws SQLException {
        String sql = "INSERT INTO customers(name, city) VALUES(?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, name);
            ps.setString(2, city);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()){
                if (keys.next()) return keys.getLong(1);
            }
        }
        throw new SQLException("no keys found or something went wrong");
    }

    static List<Customer> selectAll(Connection conn) throws SQLException {
        String sql = "SELECT id, name, city FROM customers ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
            // For a SELECT statement, you must always use executeQuery().
             ResultSet rs = ps.executeQuery()) {
            List<Customer> out = new ArrayList<>();
            while (rs.next()) out.add(mapRow(rs));
            return out;
        }
    }
      static Customer mapRow(ResultSet rs) throws SQLException {
        return new Customer(rs.getLong("id"), rs.getString("name"), rs.getString("city"));
    }
    static class Customer {
        final long id; final String name; final String city;
        Customer(long id, String name, String city) { this.id=id; this.name=name; this.city=city; }
        public String toString(){ return "Customer{id=%d, name='%s', city='%s'}".formatted(id,name,city); }
}

}