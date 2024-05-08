package com.softtek.repo;

import com.softtek.modelo.Tarea;

public interface ITareaRepo {
    Tarea obtenerTarea();
    Tarea crearTarea(Tarea t);
    void eliminarTarea(int id);
}
