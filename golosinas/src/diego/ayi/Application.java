package diego.ayi;

import diego.ayi.interfaces.IRolUsuario;
import diego.ayi.interfaces.IUsuario;
import diego.ayi.modelo.Pedido;
import diego.ayi.modelo.TipoPedido;
import diego.ayi.modelo.Usuario;
import diego.ayi.roles.RolUsuario;

public class Application {
    public static void main(String[] args) {

        // Crear roles de usuario
        IRolUsuario rolCliente = new RolUsuario("Cliente");
        IRolUsuario rolResponsable = new RolUsuario("Responsable");

        // Crear usuarios
        IUsuario usuario1 = new Usuario(1, "Juana", rolCliente);
        IUsuario usuario2 = new Usuario(2, "María", rolResponsable);

        // Crear pedidos
        Pedido pedido1 = new Pedido(101, TipoPedido.MAYORISTA, usuario1);
        Pedido pedido2 = new Pedido(102, TipoPedido.MINORISTA, usuario2);

        // Enviar pedidos a aprobación
        pedido1.enviarAprobacion(usuario2);
        pedido2.enviarAprobacion(usuario1);

        // Aprobar un pedido
        pedido1.aprobarPedido(usuario2);

        // Rechazar un pedido
        pedido2.rechazarPedido(usuario1);
    }
}
