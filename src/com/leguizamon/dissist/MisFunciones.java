package com.leguizamon.dissist;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MisFunciones {

    public static String getFechaActual() {
        Calendar cal = Calendar.getInstance();
        String mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
        String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        String anio = String.valueOf(cal.get(Calendar.YEAR));

        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        if (dia.length() == 1) {
            dia = "0" + dia;
        }
        return anio + "-" + mes + "-" + dia;
    }

    public static void configVentana(JInternalFrame ventana) {
        ventana.setVisible(true);
        Mdi.addVentana(ventana);

        // Centramos la ventana
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension v = ventana.getSize();
        ventana.setLocation((pantalla.width - v.width) / 2, (pantalla.height - v.height) / 2);
        ventana.toFront();
        ventana.requestFocus();

        // Este código borra la flecha izquierda que aparece en los JInternalFrame y que no se utilizan
        BasicInternalFrameUI ui = (BasicInternalFrameUI) ventana.getUI();
        Container north = (Container) ui.getNorthPane();
        north.remove(0);
        north.validate();
        north.repaint();
    }

    /**
     * Revisa todas las órdenes de producción para devolver el próximo número de
     * Orden de Producción
     *
     * @return
     */
    public static int getProximoNumeroOrden() {
        Ordenes ordenes = new Ordenes();
        ArrayList<OrdenProduccion> arrayOrdenes = ordenes.getArrayOrdenes();
        int nuevoNumeroOrden = 0;
        for (OrdenProduccion op : arrayOrdenes) {
            if (op.getNumeroOrden() > nuevoNumeroOrden) {
                nuevoNumeroOrden = op.getNumeroOrden() + 1;
            }
        }

        return nuevoNumeroOrden == 0 ? 1 : nuevoNumeroOrden;
    }

    /**
     * Reevisa todas las horas para devolver el próximo Id de la Hora
     *
     * @return
     */
    public static int getProximoIdHoras() {
        Horas horas = new Horas();
        ArrayList<Hora> arrayHoras = horas.getArrayHoras();
        int nuevoId = 0;
        for (Hora hora : arrayHoras) {
            if (hora.getId() > nuevoId) {
                nuevoId = hora.getId() + 1;
            }
        }
        return nuevoId == 0 ? 1 : nuevoId;
    }

    public static Turno getTurnoByHora(int hora) {
        List<Integer> turnoM = Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13);
        List<Integer> turnoT = Arrays.asList(14, 16, 17, 18, 19, 20, 21);
        List<Integer> turnoN = Arrays.asList(22, 23, 0, 1, 2, 3, 4, 5);
        ArrayList<Turno> arrayTurnos = Mdi.getArrayTurnos();
        Turno turnoEncontrado = new Turno();

        if (turnoM.contains(hora)) {
            for (Turno t : arrayTurnos) {
                if (t.getInicio() == turnoM.get(0)) {
                    turnoEncontrado = t;
                }
            }
        } else if (turnoT.contains(hora)) {
            for (Turno t : arrayTurnos) {
                if (t.getInicio() == turnoT.get(0)) {
                    turnoEncontrado = t;
                }
            }
        } else {
            for (Turno t : arrayTurnos) {
                if (t.getInicio() == turnoN.get(0)) {
                    turnoEncontrado = t;
                }
            }
        }
        return turnoEncontrado;
    }

    public static OrdenProduccion getOrdenProduccionByNumero(int numeroOrden) {
        Ordenes ordenes = new Ordenes();
        ArrayList<OrdenProduccion> arrayOrdenes = ordenes.getArrayOrdenes();
        for (OrdenProduccion op : arrayOrdenes) {
            if (op.getNumeroOrden() == numeroOrden) {
                return op;
            }
        }
        return null;
    }

    public static String completarHora(int hora) {
        return hora < 10 ? "0" + hora + ":00 hs." : hora + ":00 hs.";
    }

    public static Hora getHoraById(int id) {
        Horas horas = new Horas();
        ArrayList<Hora> arrayHoras = horas.getArrayHoras();
        for (Hora h : arrayHoras) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
