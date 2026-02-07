package com.service;

import java.util.List;

import com.excepciones.TareaExcepciones;
import com.models.Tarea;

public interface IServicioTarea {

    public void crearTarea();

    public Tarea obtenerPorId(int id) throws TareaExcepciones;

    public List<Tarea> listarTareas() throws TareaExcepciones;

    public void cambiarEstado() throws TareaExcepciones;

    public void cambiarNombreTarea() throws TareaExcepciones;

    public void eliminarTarea() throws TareaExcepciones;

}
