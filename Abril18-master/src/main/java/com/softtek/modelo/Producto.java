package com.softtek.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {

    private int product_id;
    private String product_name;
    private int supplier_id;
    private int category_id;
    private String quantity_per_unit;
    private int unit_price;
    private int units_in_stock;
    private int units_on_order;
    private int reorder_level;
    private int discontinued;

    @Override
    public String toString() {
        return "Producto{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", supplier_id=" + supplier_id +
                ", category_id=" + category_id +
                ", quantity_per_unit='" + quantity_per_unit + '\'' +
                ", unit_price=" + unit_price +
                ", units_in_stock=" + units_in_stock +
                ", units_on_order=" + units_on_order +
                ", reorder_level=" + reorder_level +
                ", discount=" + discontinued +
                '}';
    }
}
