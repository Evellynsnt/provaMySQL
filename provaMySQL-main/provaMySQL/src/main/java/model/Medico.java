
package model;

/**
 *
 * @author evellynsantospinto
 */
public class Medico {
    private int idMedico;
    private String nomeMedico;
    private String especialidade;
    private String crm;

    public Medico() {
    
 }

    public Medico(String nomeMedico, String especialidade, String crm) {
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public Medico(int idMedico, String nomeMedico, String especialidade, String crm) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico    ;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }  
}
