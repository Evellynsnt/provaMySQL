
package controller;

import dao.ConsultaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import model.Consulta;
import java.util.ArrayList;

/**
 *
 * @author evellynsantospinto
 */
public class ConsultaController {
      private ConsultaDAO dao = new ConsultaDAO();

    public void cadastrar(int idPaciente, int idMedico, LocalDate data, LocalTime hora, String observacao) {
        Consulta c = new Consulta(idPaciente, idMedico, data, hora, observacao);
        dao.inserir(c);
    }

       public ArrayList<Consulta> listar() {
        return dao.listar();
    }
    
    public void atualizar(int idConsulta, int idPaciente, int idMedico, String nomeMedico, LocalDate data, LocalTime hora , String observacao) {
        Consulta c = new Consulta(idConsulta, idMedico, idPaciente, data, hora, observacao);
        dao.atualizar(c);
    }
    
    public void remover(int idMedico) {
        dao.remover(idMedico);
    }
    
   
}
