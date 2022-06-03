package main.logic.database;
import java.security.PublicKey;
import java.sql.*;

public class Database {
    Connection conn = null;
    Statement stmt = null;
    public Database() {
    }

    public  void connect(){

        try {
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:database.db");

        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public  void  flush(){
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet query(PreparedStatement ps){
        ResultSet resultSet = null;
        try {
            ps.execute();
           resultSet = ps.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet query(String query){
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            return stmt.getResultSet();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
