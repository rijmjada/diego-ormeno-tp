package diego.ayi.interfaces;

public interface IUsuario {
    int getId();
    String getNombre();
    void setId(int id);
    void setNombre(String nombre);
    boolean tieneRol(String nombreRol);
}
