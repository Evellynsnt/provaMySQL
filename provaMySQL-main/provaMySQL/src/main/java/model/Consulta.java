
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author evellynsantospinto
 */
public class Consulta {
     private int idConsulta;
     private int idPaciente;
     private int idMedico;
     private LocalDate data;
     private LocalTime hora;
     private String observacao;
     
     
     public Consulta() {
         
     }

    public Consulta(int idPaciente, int idMedico, LocalDate data, LocalTime hora, String observacao) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public Consulta(int idConsulta, int idPaciente, int idMedico, LocalDate data, LocalTime hora, String observacao) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
     
    
    
}