package pe.edu.tecsup.mvp.app.vista;

import org.springframework.stereotype.Component;
import pe.edu.tecsup.mvp.app.modelo.Tarea;

import java.util.List;

@Component
public class TareaVista {

    private List<Tarea> tareas;

    public List<Tarea> getTareas() { return tareas; }
    public void setTareas(List<Tarea> tareas) { this.tareas = tareas; }
}
