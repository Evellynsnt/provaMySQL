package dao;

import conexao.ConexaoMySQL;
import java.sql.*;
import java.util.ArrayList;
import model.Paciente;

public class PacienteDAO {

    // Método para inserir paciente no banco de dados
    public boolean inserir(Paciente paciente) {
        String sql = "INSERT INTO paciente (nomePaciente, cpf, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  // Retorna true se a inserção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna false em caso de erro
        }
    }

    // Método para listar todos os pacientes
    public ArrayList<Paciente> listar() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("idPaciente"),
                        rs.getString("nomePaciente"),
                        rs.getString("cpf"),
                        rs.getString("telefone")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para buscar paciente(s) por nome
    public ArrayList<Paciente> buscarPorNome(String nomePaciente) {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nomePaciente LIKE ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nomePaciente + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("idPaciente"),
                        rs.getString("nomePaciente"),
                        rs.getString("cpf"),
                        rs.getString("telefone")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para atualizar dados de um paciente
    public boolean atualizar(Paciente paciente) {
        String sql = "UPDATE paciente SET nomePaciente = ?, cpf = ?, telefone = ? WHERE idPaciente = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.setInt(4, paciente.getIdPaciente());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  // Retorna true se a atualização foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna false em caso de erro
        }
    }

    // Método para remover um paciente
    public boolean remover(int idPaciente) {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  // Retorna true se a remoção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna false em caso de erro
        }
    }
}
