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

    private final List<Tarea> tareas = new ArrayList<>();

    @Override
    public void crearTarea() {
        Tarea tarea = new Tarea();
        log.info("Ingresa la tarea a crear");
        log.info("Ingresa el nombre de la tarea");
        String descripcion = escanear.nextLine().trim().toLowerCase();
        log.info("Ingresa el estado  de la tarea");
        String estado = escanear.nextLine().trim().toLowerCase();
        if (descripcion.isEmpty() && estado.isEmpty()) {
            log.error("Los datos no pueden estar vacíos");
        } else {
            tarea.modificarDescripcion(descripcion);
            tarea.modificarEstado(estado);
            tareas.add(tarea);
        }

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
    public void cambiarEstado() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas para modificar");
        }

        log.info("Ingrese el id de la tarea a modificar");
        int id = escanear.nextInt();
        escanear.nextLine();

        if (id < 0 || id >= tareas.size()) {
            throw new TareaExcepciones("No existe la tarea con id: " + id);
        }

        log.info("Ingresa el nuevo estado de la tarea");
        String estado = escanear.nextLine().trim().toLowerCase();

        tareas.get(id).modificarEstado(estado);
        log.info("Tarea actualizada exitosamente");

    }

    @Override
    public void cambiarNombreTarea() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas para modificar");
        }

        log.info("Ingrese el id_tarea a modificar");
        int id = escanear.nextInt();
        escanear.nextLine();

        if (id < 0 || id >= tareas.size()) {
            throw new TareaExcepciones("No existe la tarea con id: " + id);
        }

        log.info("Ingresa el nuevo descripción de la tarea");
        String nombreTarea = escanear.nextLine().trim().toLowerCase();

        tareas.get(id).modificarDescripcion(nombreTarea);
        log.info("Nombre tarea actualizada exitosamente");

    }


    @Override
    public void eliminarTarea() throws TareaExcepciones {
        if (tareas.isEmpty()) {
            throw new TareaExcepciones("No hay tareas registradas");
        }

        log.info("Ingresa el id de la tarea a eliminar");
        int id = escanear.nextInt();
        escanear.nextLine();

        if (id < 0 || id >= tareas.size()) {
            throw new TareaExcepciones("No existe la tarea con id: " + id);
        }

        log.info("Tarea eliminada exitosamente");
        tareas.remove(id);
    }


}
