package com.softtek.controlador;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
@Data
public class Conexion {
    protected Connection conn;

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/northwind",
                "postgres", "admin");
        System.out.println("Conexion realizada con exito");
    }


}
