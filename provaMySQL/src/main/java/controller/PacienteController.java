package controller;

import dao.PacienteDAO;
import model.Paciente;
import java.util.ArrayList;


public class PacienteController {
      private PacienteDAO dao = new PacienteDAO();

    public boolean cadastrar(String nomePaciente, String cpf, String telefone) {
        Paciente p = new Paciente(nomePaciente, cpf, telefone);
        dao.inserir(p);
        return false;
    }
    
    public ArrayList<Paciente> listar() {
        return dao.listar();
    }
    
    public void atualizar(int idPaciente, String nomePaciente, String cpf, String telefone) {
        Paciente p = new Paciente(idPaciente, nomePaciente, cpf, telefone);
        dao.atualizar(p);
    }
    
    public void remover(int idPaciente) {
        dao.remover(idPaciente);
    }
    
    public ArrayList<Paciente> buscarPorNome(String nomePaciente) {
       return dao.buscarPorNome(nomePaciente);
}
}
