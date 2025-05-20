
package controller;

import dao.MedicoDAO;
import java.util.ArrayList;
import model.Medico;

/**
 *
 * @author evellynsantospinto
 */
public class MedicoController {
    private MedicoDAO dao = new MedicoDAO();

    public boolean cadastrar(String nomeMedico, String especialidade, String crm) {
        Medico m = new Medico(nomeMedico, especialidade, crm);
        dao.inserir(m);
        return false;
    }
    
    public ArrayList<Medico> listar() {
        return dao.listar();
    }
    
    public void atualizar(int idMedico, String nomeMedico, String especialidade, String crm) {
        Medico m = new Medico(idMedico, nomeMedico, especialidade, crm);
        dao.atualizar(m);
    }
    
    public void remover(int idMedico) {
        dao.remover(idMedico);
    }
    
    public ArrayList<Medico> buscarPorNome(String nomeMedico) {
       return dao.buscarPorNome(nomeMedico);
}
}
