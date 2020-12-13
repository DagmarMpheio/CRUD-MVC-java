package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        this.conn = new Conexao().getConnection();
    }

    public boolean verificarLogin(String login, String senha) throws SQLException {
        boolean check = false;
        PreparedStatement stmt = conn.prepareStatement("select * from usuario where login=? and senha=?");
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            check = true;
            
        }
        return check;
    }
}
