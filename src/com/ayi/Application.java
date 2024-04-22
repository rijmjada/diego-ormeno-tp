package com.ayi;

import com.ayi.interfaces.IRolUsuario;
import com.ayi.interfaces.IUsuario;
import com.ayi.modelo.Pedido;
import com.ayi.modelo.TipoPedido;
import com.ayi.modelo.Usuario;
import com.ayi.roles.RolUsuario;

public class Application {
    public static void main(String[] args) {
        // Crear roles de usuario
        IRolUsuario rolCreador = new RolUsuario("Creador");
        IRolUsuario rolAprobador = new RolUsuario("Aprobador");

        // Crear usuarios
        IUsuario usuario1 = new Usuario(1, "Juana", rolCreador);
        IUsuario usuario2 = new Usuario(2, "María", rolAprobador);

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
