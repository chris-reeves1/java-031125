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

batches
transactions

Exercises:

Exercise 1: Insert and Retrieve
Task: Write a method insertAndPrint that:
    Inserts a new customer with a given name and city.
    Immediately retrieves and prints the inserted customer using selectById.
    Goal: Practice insertCustomer, selectById, and understand auto-generated keys.

Exercise 2: Update Multiple Customers in a Transaction
Task: Write a method updateCitiesInTransaction that:
    Finds all customers in "Paris" or... "something"
    Updates their city to "Amsterdam" within a transaction.
    If any update fails, rollback the entire operation.
    Goal: Practice selectByCity, updateCity, and transaction rollback.

Exercise 3: Count by City
Task: Write a method countByCity(Connection conn, String city) that:
    Returns the number of customers in the given city.
    Goal: Practice writing a simple SELECT COUNT(*) ... WHERE city = ?.

Exercise 4: Batch Insert with Custom Names
Task: Write a method batchInsertCustomNames that:
    Accepts a list of names and a city.
    Inserts all names into the customers table with the same city using batch insert.
    Goal: Practice addBatch, executeBatch, and parameter binding.

Exercise 5: Delete All in a City
Task: Write a method deleteByCity(Connection conn, String city) that:
    Deletes all customers from the specified city.
    Returns the number of rows deleted.
    Goal: Practice DELETE FROM ... WHERE and parameterized statements.



solutions:

static void insertAndPrint(Connection conn, String name, String city) throws SQLException {
    long id = insertCustomer(conn, name, city);
    String customer = selectById(conn, id);
    System.out.println("Inserted and retrieved: " + customer);
}

static void updateCitiesInTransaction(Connection conn, String fromCity, String toCity) throws SQLException {
    boolean old = conn.getAutoCommit();
    conn.setAutoCommit(false);
    try {
        List<Customer> customers = selectByCity(conn, fromCity);
        for (Customer c : customers) {
            updateCity(conn, c.id, toCity);
        }
        conn.commit();
        System.out.println("Updated " + customers.size() + " customers from " + fromCity + " to " + toCity);
    } catch (SQLException e) {
        System.err.println("ROLLBACK: " + e.getMessage());
        conn.rollback();
    } finally {
        conn.setAutoCommit(old);
    }
}

static long countByCity(Connection conn, String city) throws SQLException {
    String sql = "SELECT COUNT(*) FROM customers WHERE city = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, city);
        try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }
}

static void batchInsertCustomNames(Connection conn, List<String> names, String city) throws SQLException {
    String sql = "INSERT INTO customers(name, city) VALUES(?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        for (String name : names) {
            ps.setString(1, name);
            ps.setString(2, city);
            ps.addBatch();
        }
        int[] res = ps.executeBatch();
        System.out.println("Inserted " + res.length + " custom-named customers into " + city);
    }
}


static int deleteByCity(Connection conn, String city) throws SQLException {
    String sql = "DELETE FROM customers WHERE city = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, city);
        int deleted = ps.executeUpdate();
        System.out.println("Deleted " + deleted + " customers from " + city);
        return deleted;
    }
}


*/