package com.softtek.servicio;

import com.softtek.modelo.Tarea;
import com.softtek.repo.ITareaRepo;
import com.softtek.repo.TareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServicio implements ITareaServicio{
    @Autowired
    private ITareaRepo repo;

    @Override
    public Tarea obtenerTarea(){
        return repo.obtenerTarea();
    }

    @Override
    public Tarea crearTarea(Tarea t) {
        return repo.crearTarea(t);
    }

    @Override
    public void eliminarTarea(int id) {
        repo.eliminarTarea(id);
    }
}
