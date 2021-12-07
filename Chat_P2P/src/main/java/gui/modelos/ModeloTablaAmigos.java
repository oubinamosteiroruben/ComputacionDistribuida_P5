
package gui.modelos;

import gui.paneles.MainPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.MensajeChat;
import modelos.Usuario;

public final class ModeloTablaAmigos extends AbstractTableModel {

    //private List<String> amigos;
    private HashMap<String,ArrayList<MensajeChat>> conversaciones;
    private ArrayList<String> amigos;
    private final MainPanel mp;

    // ------------------------------------------------------------------------
    // ----------------------------- Constructor ------------------------------
    public ModeloTablaAmigos() {
        this.conversaciones = new HashMap<>();
        this.amigos = new ArrayList<>();
        this.mp = null;
    }
    
    public ModeloTablaAmigos(HashMap<String,ArrayList<MensajeChat>> conversaciones, MainPanel mp) {
        this.conversaciones = conversaciones;
        this.amigos = new ArrayList<>();
        for(String amigo: this.conversaciones.keySet()){
            this.amigos.add(amigo);
        }
        this.mp = mp;
    }
    
    public ModeloTablaAmigos(MainPanel mp) {
        this.conversaciones = new HashMap<>();
        this.amigos = new ArrayList<>();
        this.mp = mp;
    }

    // ------------------------------------------------------------------------
    // -------------------------- Overrides Getters ---------------------------
    @Override
    public final int getRowCount() {
        return this.amigos.size();
    }

    @Override
    public final int getColumnCount() {
        return 1;
    }

    @Override
    public final Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado=null;

        switch (columnIndex){
            case 0: 
                resultado = this.amigos.get(rowIndex);
                Integer n = calcularMensajesNoLeidos(this.amigos.get(rowIndex));
                if(n>0){
                    resultado += " ("+n+")";
                }
        }
        return resultado;
    }

    @Override
    public final String getColumnName(int col) {
        String nombre = null;

        switch (col){
            case 0: nombre = "Amigos"; break;
        }
        return nombre;
    }

    @Override
    public final Class getColumnClass(int col) {
        Class clase = null;

        switch (col){
            case 0: clase = java.lang.String.class; break;
        }
        return clase;
    }

    // ------------------------------------------------------------------------
    // ------------------------------ Funciones -------------------------------
    public final void setFilas(HashMap<String,ArrayList<MensajeChat>> conversaciones) {
        if (conversaciones != null ) {
            this.conversaciones = conversaciones;
            this.amigos = new ArrayList<>();
            for(String amigo: this.conversaciones.keySet()){
                this.amigos.add(amigo);
            }
            fireTableDataChanged();
        }
    }

    public final String obtenerAmigo(int i) {
        return this.amigos.get(i);
    }

    public final void actualizarTabla() {
        fireTableDataChanged();
    }

    public final void nuevoAmigo(String amigo, ArrayList<MensajeChat> conversacion) {
        this.amigos.add(amigo);
        this.conversaciones.put(amigo, conversacion);
        fireTableRowsInserted(this.amigos.size() - 1, this.amigos.size() - 1);
    }
    
    private Integer calcularMensajesNoLeidos(String amigo){
        ArrayList<MensajeChat> conversacion = this.conversaciones.get(amigo);
        Integer contador = 0;
        for(MensajeChat mc: conversacion){
            if(mc.getEmisor().equals(amigo) && !mc.isLeido()){
                contador++;
            }
        }
        return contador;
    }
}