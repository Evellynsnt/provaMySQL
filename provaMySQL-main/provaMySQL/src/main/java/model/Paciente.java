package model;

public class Paciente {
    private int idPaciente;
    private String nomePaciente;
    private String cpf;
    private String telefone;

    // Construtor com ID (usado para atualizar, listar, etc)
    public Paciente(int idPaciente, String nomePaciente, String cpf, String telefone) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Construtor sem ID (usado para cadastrar)
    public Paciente(String nomePaciente, String cpf, String telefone) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
