package com.example.demo.models;

import java.util.Date;

public class UsuarioDTO {

    private String id;
    private String nombreCompleto;
    private String correoElectronico;
    private Date fechaRegistro;
    private Integer edad;
    private String numeroTelefono;
    private String rol;

    public UsuarioDTO(String id, String nombreCompleto, String correoElectronico, Date fechaRegistro, Integer edad, String numeroTelefono, String rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = fechaRegistro;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
