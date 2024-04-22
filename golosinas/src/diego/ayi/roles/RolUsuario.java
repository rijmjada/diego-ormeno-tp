package diego.ayi.roles;

import diego.ayi.interfaces.IRolUsuario;

public class RolUsuario implements IRolUsuario {
    private String nombreRol;

    public RolUsuario(String nombreRol) {
        if (!nombreRol.equals("Cliente") && !nombreRol.equals("Responsable")) {
            throw new IllegalArgumentException("El nombre de rol debe ser 'Cliente' o 'Responsable'.");
        }
        this.nombreRol = nombreRol;
    }

    @Override
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        if (!nombreRol.equals("Cliente") && !nombreRol.equals("Responsable")) {
            throw new IllegalArgumentException("El nombre de rol debe ser 'Cliente' o 'Responsable'.");
        }
        this.nombreRol = nombreRol;
    }
}
