package QDatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void main(String[] args) throws Exception{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            Statement st = conn.createStatement();{
                String ddl = """
                    CREATE TABLE IF NOT EXISTS customers (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    city VARCHAR(100) NOT NULL
                    )      
                        """;
                        st.execute(ddl);
                        System.out.println("created table customers");
            }           
    }
}
}


