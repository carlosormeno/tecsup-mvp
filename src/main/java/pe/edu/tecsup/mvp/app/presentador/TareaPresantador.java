package pe.edu.tecsup.mvp.app.presentador;

import org.springframework.stereotype.Component;
import pe.edu.tecsup.mvp.app.modelo.TareaServicio;
import pe.edu.tecsup.mvp.app.vista.TareaVista;

@Component
public class TareaPresantador {

    private final TareaServicio tareaServicio;
    private final TareaVista tareaVista;

    public TareaPresantador(TareaServicio tareaServicio, TareaVista tareaVista) {
        this.tareaServicio = tareaServicio;
        this.tareaVista = tareaVista;
    }

    public void cargarTareas() {
        tareaVista.setTareas(tareaServicio.buscarTareas());
    }

    public TareaServicio getTareaServicio() { return tareaServicio; }
    public TareaVista getTareaVista() { return tareaVista; }
}
