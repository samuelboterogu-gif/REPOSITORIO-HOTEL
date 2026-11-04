package com.hotel.model;

/**
 * Clase abstracta que representa la base para todos los usuarios del sistema de gestion hotelera.
 * 
 * @author Sistema Hotelero
 * @version 1.0
 */
public abstract class Usuario {
    protected int idUsuario;
    protected String nombre;
    protected String documento;
    protected String correo;
    protected String telefono;

    /**
     * Constructor principal de la clase Usuario.
     * 
     * @param idUsuario Identificador unico del usuario
     * @param nombre Nombre completo del usuario
     * @param documento Numero de documento de identidad
     * @param correo Direccion de correo electronico
     * @param telefono Numero telefonico de contacto
     */
    public Usuario(int idUsuario, String nombre, String documento, String correo, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Inicia la sesion del usuario en el sistema.
     * 
     * @return true si la autenticacion es exitosa, false en caso contrario
     */
    public boolean iniciarSesion() {
        return true;
    }

    /**
     * Actualiza la informacion personal de contacto del usuario.
     */
    public void actualizarDatos() {
        // Logica de actualizacion de datos
    }

    public int getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}