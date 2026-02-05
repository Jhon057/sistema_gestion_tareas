package com.controller;

import java.util.List;

import com.excepciones.TareaExcepciones;
import com.models.Tarea;
import com.service.ServicioTareaI;

public class TareaControl {

    private ServicioTareaI servicioTarea = new ServicioTareaI();

    public void crearTarea() {
        servicioTarea.crearTarea();
    }

    public List<Tarea> listarTareas() throws TareaExcepciones {
        return servicioTarea.listarTareas();
    }

    public Tarea listarPorId(int id) throws TareaExcepciones {
        return servicioTarea.obtenerPorId(id);
    }

    public void tareaCompletada() throws TareaExcepciones {
        servicioTarea.tareaCompletada();
    }

    public void eliminarTarea() throws TareaExcepciones {
        servicioTarea.eliminarTarea();
    }

}
