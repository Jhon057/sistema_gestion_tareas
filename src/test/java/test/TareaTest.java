package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.models.Tarea;

class TareaTest {

    @Test

    void crearTarea() {

        String descripcion = "Aprender Java";
        String estado = "EN PROCESO";

        Tarea tarea = new Tarea(descripcion, estado);

        assertNotNull(tarea);
        assertEquals(descripcion, tarea.obtenerDescripcion());
        assertEquals(estado, tarea.obtenerEstado());
        assertTrue(tarea.obtenerId() > 0);
    }

    @Test
    void modificarTarea() {
        Tarea tarea = new Tarea("Aprender Java", "PENDIENTE");

        tarea.modificarEstado("COMPLETADA");

        assertEquals("COMPLETADA", tarea.obtenerEstado());
    }
}
