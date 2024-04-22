package com.ayi.modelo;

import com.ayi.interfaces.IUsuario;

public class Pedido {
    private int id;
    private Estado estado;
    private TipoPedido tipo;
    private IUsuario creador;
    private IUsuario responsable;

    public Pedido(int id, TipoPedido tipo, IUsuario creador) {
        this.id = id;
        this.estado = Estado.BORRADOR;
        this.tipo = tipo;
        this.creador = creador;
    }

    public void enviarAprobacion(IUsuario responsable) {
        if (this.estado == Estado.BORRADOR) {
            this.responsable = responsable;
            this.estado = Estado.PENDIENTE_APROBACION;
            System.out.println("El pedido #" + this.id + " ha sido enviado a " + responsable.getNombre() + " para su aprobación.");
        } else {
            System.out.println("El pedido #" + this.id + " no se puede enviar a aprobación en su estado actual.");
        }
    }

    public void aprobarPedido(IUsuario aprobador) {
        if (this.estado == Estado.PENDIENTE_APROBACION && esAprobadorValido(aprobador)) {
            this.estado = Estado.APROBADO;
            System.out.println("El pedido #" + this.id + " ha sido aprobado por " + aprobador.getNombre() + ".");
        } else {
            System.out.println("El pedido #" + this.id + " no se puede aprobar en su estado actual o por este usuario.");
        }
    }

    public void rechazarPedido(IUsuario aprobador) {
        if (this.estado == Estado.PENDIENTE_APROBACION && esAprobadorValido(aprobador)) {
            this.estado = Estado.RECHAZADO;
            System.out.println("El pedido #" + this.id + " ha sido rechazado por " + aprobador.getNombre() + ".");
        } else {
            System.out.println("El pedido #" + this.id + " no se puede rechazar en su estado actual o por este usuario.");
        }
    }

    // Método para comprobar si el usuario es un aprobador válido para el pedido
    private boolean esAprobadorValido(IUsuario usuario) {
        return usuario != null && usuario.tieneRol("Aprobador");
    }

    // Getters y setters con validaciones de entrada
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El ID debe ser un valor positivo.");
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        if (tipo != null) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("El tipo de pedido no puede ser nulo.");
        }
    }

    public IUsuario getCreador() {
        return creador;
    }

    public void setCreador(IUsuario creador) {
        if (creador != null) {
            this.creador = creador;
        } else {
            throw new IllegalArgumentException("El creador no puede ser nulo.");
        }
    }

    public IUsuario getResponsable() {
        return responsable;
    }

    public void setResponsable(IUsuario responsable) {
        if (responsable != null) {
            this.responsable = responsable;
        } else {
            throw new IllegalArgumentException("El responsable no puede ser nulo.");
        }
    }
}
