package com.leguizamon.dissist;

import java.util.ArrayList;

public class Colores {

    public Colores() {

    }

    public ArrayList<Color> cargarColoresPredeterminados() {
        ArrayList<Color> colores = new ArrayList<>();
        Color color1 = new Color("101", "A1", "Azul");
        Color color2 = new Color("101", "A2", "Blanco");
        Color color3 = new Color("102", "B1", "Azul");
        Color color4 = new Color("102", "B2", "Rojo");
        colores.add(color1);
        colores.add(color2);
        colores.add(color3);
        colores.add(color4);
        return colores;
    }

    public ArrayList<Color> getArrayColores() {
        return Mdi.getArrayColores();
    }

    public void agregarColor(Color color) {
        Mdi.addColor(color);
    }

    public String getColorByCodigo(String sku, String codigo) {
        Colores colores = new Colores();
        ArrayList<Color> arrayColores = colores.getArrayColores();
        
        for (Color c : arrayColores) {
            if (c.getSku().equals(sku)) {
                if (c.getCodigo().equals(codigo)) {
                    return c.getDescripcion();
                }
            }

        }
        return null;
    }

}
