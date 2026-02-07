package com.tareas;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.TareaControl;
import com.excepciones.TareaExcepciones;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Scanner escanear = new Scanner(System.in);

    public static void main(String[] args) {
        TareaControl tareaControl = new TareaControl();
        log.info("Tareas");
        boolean ejecucion = true;

        while (ejecucion) {
            try {
                menu();
                log.info("Selecciona opción");
                int seleccion = escanear.nextInt();
                escanear.nextLine();

                switch (seleccion) {
                    case 1:
                        tareaControl.crearTarea();
                        break;

                    case 2:
                        tareaControl.listarTareas().forEach(t -> log.info("{}", t));
                        break;

                    case 3:
                        log.info("Ingrese el id de la tarea a buscar");
                        int id = escanear.nextInt();
                        escanear.nextLine();
                        log.info("{}", tareaControl.listarPorId(id));
                        break;

                    case 4:
                        tareaControl.cambiarEstado();
                        break;
                    case 5:
                        tareaControl.cambiarNombreTarea();
                        break;

                    case 6:
                        tareaControl.eliminarTarea();
                        break;

                    case 7:
                        ejecucion = false;
                        log.info("Saliendo del programa");
                        break;

                    default:
                        log.error("No existe esa opción");
                }

            } catch (TareaExcepciones e) {
                log.error("Error: {}", e.getMessage());
            } catch (Exception e) {
                log.error("Entrada inválida. Intenta nuevamente.");
                escanear.nextLine();
            }
        }
    }


    public static void menu() {
        log.info("1. Registrar tarea");
        log.info("2. Listar tareas");
        log.info("3. Buscar por id tarea");
        log.info("4. Cambiar estado de tarea");
        log.info("5. Cambiar nombre de la tarea");
        log.info("6. Eliminar tarea por ID");
        log.info("7. Salir");
    }
}
