package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = new Conexao().getConnection();
        if(conn!=null)
            System.out.println("Conectado com sucesso!");
        else
            System.out.println("Erro ao conectar");
    }
}
