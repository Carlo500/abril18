package com.softtek.repo;

import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoRepo {
    List<Producto> obtenerProducto() throws SQLException, ClassNotFoundException;
    Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException;
    void actualizarProduto(int id, int stock, int descuento, String productName) throws SQLException, ClassNotFoundException;
    void eliminarProducto(int id) throws SQLException, ClassNotFoundException;
    Producto cogerUno(int id) throws SQLException, ClassNotFoundException;
}
