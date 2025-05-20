
package model;

/**
 *
 * @author evellynsantospinto
 */
public class Paciente {
    private int idPaciente;
    private String nomePaciente;
    private String cpf;
    private String telefone;

    
    
    public Paciente() {
    
    }
             
    

    public Paciente(String nomePaciente, String cpf, String telefone) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Paciente(int idPaciente, String nomePaciente, String cpf, String telefone) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}

