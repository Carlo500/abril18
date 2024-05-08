package com.softtek.servicio;

import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerProducto() throws SQLException, ClassNotFoundException;
    Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException;
    void actualizarProducto(int id, int stock, int descuento, String productName) throws SQLException, ClassNotFoundException;
    void deleteProducto(int id) throws SQLException, ClassNotFoundException;
    Producto obtenerUno(int id) throws SQLException, ClassNotFoundException;
}
