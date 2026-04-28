package pe.edu.tecsup.mvp.app.modelo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio {

    private final TareaRepositorio tareaRepositorio;

    public TareaServicio(TareaRepositorio tareaRepositorio) {
        this.tareaRepositorio = tareaRepositorio;
    }

    public List<Tarea> buscarTareas() {
        return tareaRepositorio.buscarTodas();
    }

    public void agregar(Tarea tarea) {
        tareaRepositorio.agregar(tarea);
    }

    public void eliminar(int id) {
        tareaRepositorio.eliminar(id);
    }

    public void cambiarEstadoTarea(int id) {
        tareaRepositorio.cambiarEstadoTarea(id);
    }
}
