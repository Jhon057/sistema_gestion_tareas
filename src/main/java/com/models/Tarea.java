package com.models;

public class Tarea {

    private int id;
    private String descripcion;
    private String estado;
    private static int contador = 0;

    public Tarea() {
        this.id = ++Tarea.contador;
    }

    public Tarea(String descripcion, String estado) {
        this();
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int obtenerId() {
        return this.id;
    }

    public String obtenerDescripcion() {
        return this.descripcion;
    }

    public void modificarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String obtenerEstado() {
        return this.estado;

    }

    public void modificarEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tarea id: ");
        builder.append(id);
        builder.append(", descripción: ");
        builder.append(descripcion);
        builder.append(", estado: ");
        builder.append(estado);
        return builder.toString();
    }

}
