package com.service;

import java.util.List;

import com.excepciones.TareaExcepciones;
import com.models.Tarea;

public interface IServicioTarea {

    public Tarea crearTarea();

    public Tarea obtenerPorId(int id) throws TareaExcepciones;

    public List<Tarea> listarTareas() throws TareaExcepciones;

    public String tareaCompletada();

    public Tarea eliminarTarea() throws TareaExcepciones;

}
