package com.softtek.controlador;

import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorProducto {
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping
    public List<Producto> obtenerProcuto() throws SQLException, ClassNotFoundException {
        return productoServicio.obtenerProducto();
    }

    @GetMapping("/{id}")
    public Producto obtenerUnProducto(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return productoServicio.obtenerUno(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto p) throws SQLException, ClassNotFoundException {
        return productoServicio.crearProducto(p);
    }
    @PutMapping
    public void modificarProducto(@RequestBody Producto p) throws Exception {
        Producto p1= productoServicio.obtenerUno(p.getProduct_id());
        if (p1==null){
            throw new Exception("Empleado no encontrado "+ p.getProduct_id());
        }
        productoServicio.actualizarProducto(p.getProduct_id(),p.getUnits_in_stock(),p.getDiscontinued(),p.getProduct_name());
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) throws SQLException, ClassNotFoundException {
        productoServicio.deleteProducto(id);
    }
}
