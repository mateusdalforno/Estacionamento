
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mateu
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = 
            "jdbc:mysql://localhost:3307/estacionamento";
    public static final String USER = "root";
    public static final String PASS = "";
    
public static Connection getConnection(){
    try{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }catch (ClassNotFoundException | SQLException e){
        throw new RuntimeException ("Erro na conexão: ", e);
    }
}

public static void closeConnection(Connection con){
    try{
        if(con != null){
            con.close();
        }
    }catch (SQLException e){
        throw new RuntimeException("Erro ao desconectar: ", e);
    }
}

public static void closeConnection(Connection con, PreparedStatement stmt){
    closeConnection(con);
    try{
        if(stmt != null){
            stmt.close();
        }
    }catch (SQLException e){
        throw new RuntimeException("Erro ao desconectar: ", e);
    }
}

public static void closeConnection(Connection con, PreparedStatement stmt, 
        ResultSet rs){
    closeConnection(con, stmt);
    try{
        if(rs != null){
            rs.close();
        }
    }catch (SQLException e){
        throw new RuntimeException("Erro ao desconectar: ", e);
    }
}

}