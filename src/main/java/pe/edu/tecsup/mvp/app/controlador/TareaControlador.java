package pe.edu.tecsup.mvp.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.tecsup.mvp.app.modelo.Tarea;
import pe.edu.tecsup.mvp.app.presentador.TareaPresantador;

@Controller
@RequestMapping("/tareas")
public class TareaControlador {

    private final TareaPresantador tareaPresantador;

    public TareaControlador(TareaPresantador tareaPresantador) {
        this.tareaPresantador = tareaPresantador;
    }

    @GetMapping
    public String listar(Model model) {
        tareaPresantador.cargarTareas();
        model.addAttribute("tareas", tareaPresantador.getTareaVista().getTareas());
        return "tareas/lista";
    }

    @PostMapping("/agregar")
    public String agregar(@RequestParam String titulo) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(titulo);
        tareaPresantador.getTareaServicio().agregar(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        tareaPresantador.getTareaServicio().eliminar(id);
        return "redirect:/tareas";
    }

    @GetMapping("/completar/{id}")
    public String completar(@PathVariable int id) {
        tareaPresantador.getTareaServicio().cambiarEstadoTarea(id);
        return "redirect:/tareas";
    }
}
