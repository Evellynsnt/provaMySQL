
package controller;

import dao.ConsultaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import model.Consulta;

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
    
   
}
