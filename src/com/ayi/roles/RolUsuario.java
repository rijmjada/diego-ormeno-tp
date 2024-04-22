package com.ayi.roles;

import com.ayi.interfaces.IRolUsuario;

public class RolUsuario implements IRolUsuario {
    private String nombreRol;

    public RolUsuario(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String getNombreRol() {
        return nombreRol;
    }

    // Getters y setters
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
