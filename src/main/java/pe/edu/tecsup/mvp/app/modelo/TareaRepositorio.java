package pe.edu.tecsup.mvp.app.modelo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepositorio {

    private final List<Tarea> tareas = new ArrayList<>();
    private int contadorId = 1;

    public List<Tarea> buscarTodas() {
        return tareas;
    }

    public void agregar(Tarea tarea) {
        tarea.setId(contadorId++);
        tareas.add(tarea);
    }

    public void eliminar(int id) {
        tareas.removeIf(t -> t.getId() == id);
    }

    public void cambiarEstadoTarea(int id) {
        tareas.stream()
              .filter(t -> t.getId() == id)
              .findFirst()
              .ifPresent(t -> t.setCompletada(!t.isCompletada()));
    }
}
