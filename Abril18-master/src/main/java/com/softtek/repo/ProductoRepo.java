package com.softtek.repo;

import com.softtek.controlador.AccesoProducto;
import com.softtek.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepo implements IProductoRepo{

    AccesoProducto accesoProducto = new AccesoProducto();

    @Override
    public List<Producto> obtenerProducto() throws SQLException, ClassNotFoundException {
        return accesoProducto.allProducts();
    }

    @Override
    public Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException {
        accesoProducto.insertProduct(p.getProduct_id(),p.getProduct_name(),p.getSupplier_id(),p.getCategory_id(),p.getQuantity_per_unit(),p.getUnit_price(),p.getUnits_in_stock(),p.getUnits_on_order(),p.getReorder_level(),p.getDiscontinued());
        return p;
    }

    @Override
    public void actualizarProduto(int id, int stock, int descuento, String productName) throws SQLException, ClassNotFoundException {
        accesoProducto.updateStockByID(id, stock, descuento,productName);
    }

    @Override
    public void eliminarProducto(int id) throws SQLException, ClassNotFoundException {
        accesoProducto.deleteProductByID(id);
    }

    @Override
    public Producto cogerUno(int id) throws SQLException, ClassNotFoundException{
        return accesoProducto.oneProduct(id);
    }
}
