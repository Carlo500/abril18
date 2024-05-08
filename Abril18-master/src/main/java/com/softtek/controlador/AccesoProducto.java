package com.softtek.controlador;

import com.softtek.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion{
    public Statement sentencia;
    public ResultSet resultado;

    public List<Producto> allProducts() throws SQLException, ClassNotFoundException {
        conectar();
        String sql = "SELECT * FROM products;";
        List<Producto> productos = new ArrayList<>();
        sentencia = conn.createStatement();
        resultado = sentencia.executeQuery(sql);
        while(resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getInt("supplier_id"),
                    resultado.getInt("category_id"),
                    resultado.getString("quantity_per_unit"),
                    resultado.getInt("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("units_on_order"),
                    resultado.getInt("reorder_level"),
                    resultado.getInt("discontinued")));
        }
        return productos;
    }
    public Producto oneProduct(int id) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "SELECT * FROM products WHERE product_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,id);
        Producto producto = null;
        resultado = ps.executeQuery();
        if (resultado.next()) {
            producto = new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getInt("supplier_id"),
                    resultado.getInt("category_id"),
                    resultado.getString("quantity_per_unit"),
                    resultado.getInt("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("units_on_order"),
                    resultado.getInt("reorder_level"),
                    resultado.getInt("discontinued"));
        }
        return producto;
    }

    public void insertProduct(int product_id,
                              String product_name,
                              int supplier_id,
                              int category_id,
                              String quantity_per_unit,
                              int unit_price,
                              int units_in_stock,
                              int units_on_order,
                              int reorder_level,
                              int discount) throws SQLException, ClassNotFoundException {
        conectar();

        String query = "INSERT INTO products VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,product_id);
        ps.setString(2,product_name);
        ps.setInt(3,supplier_id);
        ps.setInt(4,category_id);
        ps.setString(5,quantity_per_unit);
        ps.setInt(6,unit_price);
        ps.setInt(7,units_in_stock);
        ps.setInt(8,units_on_order);
        ps.setInt(9,reorder_level);
        ps.setInt(10,discount);
        ps.executeUpdate();
    }

    public void updateStockByID(int id, int stock, int descuento, String productName) throws SQLException, ClassNotFoundException {
        conectar();
        System.out.println(productName);
        String query = "UPDATE products SET units_in_stock=?, discontinued=?, product_name=? WHERE product_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,stock);
        ps.setInt(2,descuento);
        ps.setString(3,productName);
        ps.setInt(4,id);
        ps.executeUpdate();
    }

    public void deleteProductByID(int id) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "DELETE FROM products WHERE product_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
}
