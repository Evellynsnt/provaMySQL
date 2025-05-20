
package dao;

import ConexaoMySQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import model.Consulta;

/**
 *
 * @author evellynsantospinto
 */
public class ConsultaDAO {
     public void inserir(Consulta consulta) {
        String sql = "INSERT INTO consulta (idPaciente, idMedico, data, hora, observacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));
            stmt.setTime(4, Time.valueOf(consulta.getHora()));
            stmt.setString(5, consulta.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        
    }
      public ArrayList<Consulta> listar() {
        ArrayList<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta c = new Consulta(
                    rs.getInt("idConsulta"),
                    rs.getInt("idPaciente"),
                    rs.getInt("idMedico"),
                    rs.getDate("data").toLocalDate(),
                    rs.getTime("hora").toLocalTime(),
                    rs.getString("observacao")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
}
      public ArrayList<Consulta> buscarPorID(int idConsulta) {
    ArrayList<Consulta> lista = new ArrayList<>();
    String sql = "SELECT * FROM consulta WHERE idConsulta LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + idConsulta + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta c = new Consulta(
                rs.getInt("idConsulta"),
                rs.getInt("idPaciente"),
                rs.getInt("idMedico"),
                rs.getDate("data").toLocalDate(),
                rs.getTime("hora").toLocalTime(),
                rs.getString("observacao")    
            );
            lista.add(c);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
      public void atualizar(Consulta consulta) {
        String sql = "UPDATE medico SET idPaciente = ?, idMedico = ?, data  = ?,  hora = ?, observacao = ? WHERE idConsulta = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));
            stmt.setTime(4, Time.valueOf(consulta.getHora()));
            stmt.setString(5, consulta.getObservacao());
            stmt.setInt(6, consulta.getIdConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 }
       public void remover(int idConsulta) {
        String sql = "DELETE FROM consulta WHERE idConsulta = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idConsulta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
