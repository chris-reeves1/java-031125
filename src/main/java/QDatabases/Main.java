package QDatabases;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println(meta.getDatabaseProductName());
            System.out.println(meta.getDatabaseProductVersion());
            System.out.println(meta.getDriverName());
            System.out.println(meta.getURL());
            System.out.println(meta.getUserName());
        }
    }



}


/*

Databases:

JDBC: 
    - Standards/specifications (framework) - for how to connect from java to a db.
    - defines the interface that devs use to connect.
    - java.sql - lots of methods and classes. DriverManager. 
    - The driver manager: - helps select the right driver that has been reigistered.
    - It handles all low-level communication with the db. 

h2 - In memory db.
- Convenience: no setup, no installations, no external dependancies.
             - good for learning, prototyping, testing.  
- Speed: Read/write very fast - especially when fresh and small. Test/dev time is quicker.
- Teardown - automatic + options for persistance. 
- introducing debt - eventuall we need to change to a prod ready db - most code doesnt need to change.  



URL = "jdbc:h2:mem:testdb"

connection:vendor:options/name:options







*/