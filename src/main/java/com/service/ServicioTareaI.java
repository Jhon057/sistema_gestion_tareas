package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excepciones.TareaExcepciones;
import com.models.Tarea;

public class ServicioTareaI implements IServicioTarea {

    private static final Logger log = LoggerFactory.getLogger(ServicioTareaI.class);
    private static final Scanner escanear = new Scanner(System.in);

    private List<Tarea> tareas = new ArrayList<>();

    @Override
    public Tarea crearTarea() {
        Tarea tarea = new Tarea();
        log.info("Ingresa la tarea a crear");
        log.info("Ingresa el nombre de la tarea");
        String descripcion = escanear.nextLine();
        log.info("Ingresa el estado  de la tarea");
        String estado = escanear.nextLine();
        tarea.modificarDescripcion(descripcion);
        tarea.modificarEstado(estado);
        tareas.add(tarea);
        return tarea;
    }

    @Override
    public Tarea obtenerPorId(int id) throws TareaExcepciones {
        if (tareas.get(id) == null) {
            throw new TareaExcepciones("No exista la tarea con id: " + id);
        }
        return tareas.get(id);
    }

    @Override
    public List<Tarea> listarTareas() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas");
        }

        return tareas;
    }

    @Override
    public String tareaCompletada() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas para modificar");
        }
        int id;
        String estado;
        log.info("Ingrese el id de la tarea a modificar");
        id = escanear.nextInt();
        escanear.nextLine();
        log.info("Ingresa el nuevo estado de la tarea");
        estado = escanear.nextLine();

        Tarea existe = tareas.get(id);
        if (existe != null) {
            existe.modificarEstado(estado);
            log.info("tarea actualizada exitosamente");
            return "Se ha actualizado la tarea con éxito";
        }
        return "Tarea no encontrada";
    }

    @Override
    public Tarea eliminarTarea() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas");
        }
        log.info("Ingresa el id de la tarea a eliminar");
        int id = escanear.nextInt();
        if (tareas.get(id) == null) {
            throw new TareaExcepciones("No exista la tarea con id: " + id);
        }
        log.info("tarea eliminada exitosamente");
        return tareas.remove(id);
    }

}
