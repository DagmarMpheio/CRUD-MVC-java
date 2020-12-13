package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Funcionario;

public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO() {
        this.conn = new Conexao().getConnection();
    }

    //metodo adicionar Funcionario
    public void adiciona(Funcionario funcionario) throws SQLException {
        String sql = "insert into funcionario"
                + " (nome, usuario, senha)"
                + " values (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar!");
            throw new RuntimeException(e);
        }
    }

    //listar dados
    public List<Funcionario> getLista() {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from funcionario order by id");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));

                //adiciona no ArrayList
                funcionarios.add(f);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Actualizar dados
    public void alterar(Funcionario f) throws SQLException {
        String sql = "update funcionario set nome=?, usuario=?, senha=? where id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getUsuario());
            stmt.setString(3, f.getSenha());
            stmt.setLong(4, f.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados " + e);
            throw new RuntimeException(e);
        }
    }

    //apagar dados
    public void apagar(Funcionario f) throws SQLException {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("delete from funcionario where id=?");
            stmt.setLong(1, f.getId());
            stmt.execute();
             JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel apagar esses dados!");
        }
    }
    
//pesquisar dados
    public List<Funcionario> pesquisar(String pes) {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from funcionario where usuario like ? or nome like ?");
            stmt.setString(1, "%"+pes+"%");
            stmt.setString(2, "%"+pes+"%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));

                //adiciona no ArrayList
                funcionarios.add(f);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
