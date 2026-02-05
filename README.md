# Sistema de Gestión de Tareas

Este proyecto es una aplicación de consola en Java para la gestión de tareas. Permite a los usuarios crear, listar, buscar, actualizar (completar/modificar estado) y eliminar tareas mediante un menú interactivo.

## Estructura del Proyecto

El proyecto está organizado en paquetes que separan la lógica de negocio, el modelo de datos, el control y la interfaz de usuario (consola).

### Paquetes Principales

- 'com.tareas': Contiene la clase principal de punto de entrada.
- 'com.models': Define el modelo de datos (la entidad Tarea).
- 'com.controller': Capa intermedia que gestiona el flujo entre la vista (Main) y los servicios.
- 'com.service': Lógica de negocio y manipulación de datos.
- 'com.excepciones': Manejo de excepciones personalizadas.

## Clases y Funcionalidad

A continuación se detalla cada clase y su responsabilidad en el sistema:

### 1. 'com.models.Tarea'
Representa la entidad **Tarea**.
- **Atributos**:
  - 'id': Identificador único auto-incremental.
  - 'descripción': Descripción detallada de la tarea.
  - 'estado': Estado actual de la tarea (ej. "PENDIENTE", "COMPLETADA").
- **Funcionalidad**: Provee constructores para inicializar tareas y métodos *getter* y *setter* para acceder y modificar sus datos. Sobrescribe el método 'toString()' para una representación legible.

### 2. 'com.controller.TareaControl'
Actúa como controlador o intermediario.
- **Funcionalidad**:
  - Conecta la clase principal ('Main') con la capa de servicio ('ServicioTareaI').
  - Expone métodos públicos ('crearTarea', 'listarTareas', 'listarPorId', etc.) que delegan la ejecución a la instancia del servicio.

### 3. 'com.service.IServicioTarea' (Interfaz) y 'ServicioTareaI' (Implementación)
Contienen la lógica de negocio principal.
- **'IServicioTarea'**: Define el contrato (métodos) que debe implementar el servicio.
- **'ServicioTareaI'**: Implementa la lógica.
  - Mantiene una lista en memoria ('List<Tarea> tareas') para almacenar las tareas.
  - **Métodos Clave**:
    - 'crearTarea()': Solicita datos al usuario y añade una nueva tarea a la lista.
    - 'listarTareas()': Devuelve la lista completa o lanza una excepción si está vacía.
    - 'obtenerPorId(int id)': Busca una tarea específica por su índice/ID.
    - 'tareaCompletada()': Permite modificar el estado de una tarea existente.
    - 'eliminarTarea()': Elimina una tarea de la lista basada en su ID.
  - *Nota*: Actualmente, esta clase maneja también la entrada de datos por consola ('Scanner') para las operaciones de creación y modificación.

### 4. 'com.excepciones.TareaExcepciones'
Clase personalizada para el manejo de errores.
- **Funcionalidad**: Extiende de 'Exception' para permitir lanzar errores específicos del dominio, como intentar acceder a una tarea que no existe o listar cuando no hay registros.

### 5. 'com.tareas.Main'
Punto de entrada de la aplicación ('public static void main').
- **Funcionalidad**:
  - Inicializa el controlador y el escáner.
  - Presenta un bucle infinito con un menú de opciones:
    1. **Registrar tarea**: Llama a 'crearTarea'.
    2. **Listar tareas**: Muestra todas las tareas registradas.
    3. **Buscar por id tarea**: Busca y muestra una tarea específica.
    4. **Cambiar estado de tarea**: Actualiza el estado de una tarea.
    5. **Eliminar tarea por ID**: Borra una tarea del sistema.
    6. **Salir**: Termina la ejecución del programa.
  - Gestiona la captura de excepciones ('TareaExcepciones') y el registro de logs ('SLF4J').

## Ejecución del Proceso

1. Al iniciar la aplicación, se muestra el menú principal en la consola.
2. El usuario ingresa un número correspondiente a la opción deseada.
3. El sistema solicita los datos necesarios (por ejemplo, descripción de la tarea o el ID).
4. La operación se realiza y se muestra el resultado o un mensaje de error si ocurre alguna excepción (ej. "Tarea no encontrada").
5. El ciclo continúa hasta que el usuario selecciona la opción "Salir".

## Pruebas Unitarias

El proyecto incluye pruebas unitarias en 'src/test/java/test/TareaTest.java' utilizando **JUnit 5**.
- 'crearTarea()': Verifica que una tarea se instancie correctamente con sus atributos y un ID válido.
- 'modificarTarea()': Verifica que el cambio de estado de una tarea funcione correctamente.
