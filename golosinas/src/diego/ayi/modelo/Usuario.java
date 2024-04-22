package diego.ayi.modelo;

import diego.ayi.interfaces.IRolUsuario;
import diego.ayi.interfaces.IUsuario;

public class Usuario implements IUsuario {
    private int id;
    private String nombre;
    private IRolUsuario rol;

    public Usuario(int id, String nombre, IRolUsuario rol) {
        setId(id);
        setNombre(nombre);
        setRol(rol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un valor positivo.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public IRolUsuario getRol() {
        return rol;
    }

    public void setRol(IRolUsuario rol) {
        if (rol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }
        if (!rol.getNombreRol().equals("Cliente") && !rol.getNombreRol().equals("Responsable")) {
            throw new IllegalArgumentException("El rol debe ser 'Cliente' o 'Responsable'.");
        }
        this.rol = rol;
    }

    public boolean tieneRol(String nombreRol) {
        return rol != null && rol.getNombreRol().equals(nombreRol);
    }
}
