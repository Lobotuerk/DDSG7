package com.leguizamon.dissist;

public class Color {
    private String sku;
    private String codigo;
    private String descripcion;

    public Color(String sku, String codigo, String descripcion) {
        this.sku = sku;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
