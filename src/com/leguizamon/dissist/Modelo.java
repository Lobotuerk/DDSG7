package com.leguizamon.dissist;

public class Modelo {
    
    private String SKU;
    private String descripcion;

    /**
     * CONSTRUCTOR
     * @param SKU
     * @param descripcion 
     */
    public Modelo(String SKU, String descripcion) {
        this.SKU = SKU;
        this.descripcion = descripcion;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
