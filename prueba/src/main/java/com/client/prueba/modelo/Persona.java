package com.client.prueba.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tpersonas")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTPERSONA")
    private Long idtpersona;
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;

//    @OneToOne(fetch = FetchType.LAZY )
//    @JoinColumn( name="\"IDTCLIENTE\"",referencedColumnName="\"IDTCLIENTE\"",insertable=false, updatable=false)
//    //@OneToOne(mappedBy="persona")
//    private Cliente cliente;



    public Persona(Long idtpersona, String identificacion, String nombre, String genero, int edad, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.idtpersona = idtpersona;
        this.telefono = telefono;
        //this.cliente=cliente;
    }

    public Persona() {}

    public Long getIdtpersona() {
        return idtpersona;
    }


    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

}
