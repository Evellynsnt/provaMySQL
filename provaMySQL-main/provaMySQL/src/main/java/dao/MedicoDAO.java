
package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Medico;


/**
 *
 * @author evellynsantospinto
 */
public class MedicoDAO {
      public void inserir(Medico medico) {
        String sql = "INSERT INTO medico (nomeMedico, especialidade, crm) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNomeMedico());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        
    }
      public ArrayList<Medico> listar() {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medico m = new Medico(
                        rs.getInt("idMedico"),
                        rs.getString("nomeMedico"),
                        rs.getString("especialidade"),
                        rs.getString("crm")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
}
      public ArrayList<Medico> buscarPorNome(String nomeMedico) {
    ArrayList<Medico> lista = new ArrayList<>();
    String sql = "SELECT * FROM medico WHERE nomeMedico LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nomeMedico + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico m = new Medico(
                rs.getInt("idMedico"),
                rs.getString("nomeMedico"),
                rs.getString("especialidade"),
                rs.getString("crm")    
            );
            lista.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
      public void atualizar(Medico medico) {
        String sql = "UPDATE medico SET nomeMedico = ?, especialidade = ?, crm = ? WHERE idMedico = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNomeMedico());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setInt(3, medico.getIdMedico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 }
       public void remover(int idMedico) {
        String sql = "DELETE FROM medico WHERE idMedico = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMedico);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
