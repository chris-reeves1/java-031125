package QDatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Write {
private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
private static final String USER = "sa";
private static final String PASS = "";

    public static void main(String[] args) throws Exception{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            createTable(conn);

            long id1 = insertCustomer(conn, "a" , "londin");
            long id2 = insertCustomer(conn, "b", "tokyo");
            long id3 = insertCustomer(conn, "c" , "madrid");

            System.out.printf("inserted ids: %d %d %d", id1, id2, id3);

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

}




