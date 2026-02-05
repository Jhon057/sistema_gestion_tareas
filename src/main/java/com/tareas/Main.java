package com.tareas;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.TareaControl;
import com.excepciones.TareaExcepciones;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Scanner escanear = new Scanner(System.in);

    public static void main(String[] args) throws TareaExcepciones {
        TareaControl tareaControl = new TareaControl();
        log.info("Tareas");
        boolean ejecucion = true;

        while (ejecucion) {
            menu();
            log.info("Selecciona opción");
            int seleccion = escanear.nextInt();
            switch (seleccion) {
                case 1:
                    tareaControl.crearTarea();

                    break;
                case 2:
                    for (int i = 0; i < tareaControl.listarTareas().size(); i++) {
                        log.info("{}", tareaControl.listarTareas().get(i));
                    }
                    break;
                case 3:
                    log.info("Ingrese el id de la tarea a buscar");
                    int id = escanear.nextInt();
                    tareaControl.listarPorId(id);
                    log.info("{}", tareaControl.listarPorId(id));
                    break;
                case 4:
                    tareaControl.tareaCompletada();
                    break;
                case 5:
                    tareaControl.eliminarTarea();
                    break;
                case 6:
                    ejecucion = false;
                    log.info("Saliendo del programa");
                    break;

                default:
                    log.error("No existe esa opción");
                    break;
            }
        }

    }

    public static void menu() {
        log.info("1. Registrar tarea");
        log.info("2. Listar tareas");
        log.info("3. Buscar por id tarea");
        log.info("4. Cambiar estado de tarea");
        log.info("5. Eliminar tarea por ID");
        log.info("6. Salir");
    }
}