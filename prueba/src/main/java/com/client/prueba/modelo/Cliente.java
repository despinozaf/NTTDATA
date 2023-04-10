package com.client.prueba.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tclientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtcliente;

    @Column(name = "IDTPERSONA")
    private Long idtpersona;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "ESTADO")
    private boolean estado;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn( name="idtpersona",referencedColumnName="idtpersona",insertable=false, updatable=false)
    //@OneToOne(mappedBy="persona")
        private Persona persona;


    public Cliente(Long idtcliente, String contrasena, boolean estado, Long idtpersona) {
        this.idtcliente = idtcliente;
        this.contrasena = contrasena;
        this.estado = estado;
        this.idtpersona=idtpersona;
    }

    public Cliente() {}

    public Long getIdtcliente() {
        return idtcliente;
    }

    public void setIdtcliente(Long idtcliente) {
        this.idtcliente = idtcliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getIdtpersona() {
        return idtpersona;
    }

    public void setIdtpersona(Long idtpersona) {
        this.idtpersona = idtpersona;
    }


    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
