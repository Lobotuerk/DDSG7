package com.leguizamon.dissist;

import java.util.ArrayList;

public class Modelos {
    /**
     * CONSTRUCTOR VACÍO
     */
    public Modelos() {

    }

    public ArrayList<Modelo> cargarModelosPredeterminados() {
        ArrayList<Modelo> modelos = new ArrayList<>();
        Modelo modelo1 = new Modelo("101", "Deportivo");
        Modelo modelo2 = new Modelo("102", "Casual");
        modelos.add(modelo1);
        modelos.add(modelo2);
        return modelos;
    }

    public ArrayList<Modelo> getArrayModelos() {
        return Mdi.getArrayModelos();
    }

    public void addModelo(Modelo modelo) {
        Mdi.addModelo(modelo);
    }
    
     public String getModeloBySku(String sku){
        Modelos modelos = new Modelos();
        ArrayList<Modelo> arrayModelos = modelos.getArrayModelos();
        for(Modelo m : arrayModelos){
            if(m.getSKU().equals(sku)){
                return m.getDescripcion();
            }
        }
        return null;
    }
}
