package com.softtek.servicio;

import com.softtek.modelo.Tarea;

public interface ITareaServicio {
    Tarea obtenerTarea();
    Tarea crearTarea(Tarea t);

    void eliminarTarea(int id);
}
