
package gui.modelos;

import gui.paneles.MainPanel_Izq;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.Usuario;

public final class ModeloTablaAmigos extends AbstractTableModel {

    private List<Usuario> amigos;
    
    private final MainPanel_Izq mpi;

    // ------------------------------------------------------------------------
    // ----------------------------- Constructor ------------------------------
    public ModeloTablaAmigos() {
        this.amigos = new ArrayList<>();
        this.mpi = null;
    }
    
    public ModeloTablaAmigos(List<Usuario> amigos, MainPanel_Izq mpi) {
        this.amigos = amigos;
        this.mpi = mpi;
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
            case 0: resultado = this.amigos.get(rowIndex).getUsername(); break;
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
    public final void setFilas(java.util.List<Usuario> amigos) {
        if (amigos != null ) {
            this.amigos = amigos;
            fireTableDataChanged();
        }
    }

    public final Usuario obtenerAmigo(int i) {
        return this.amigos.get(i);
    }

    public final void actualizarTabla() {
        fireTableDataChanged();
    }

    public final void nuevoAmigo(Usuario u) {
        this.amigos.add(u);
        fireTableRowsInserted(this.amigos.size() - 1, this.amigos.size() - 1);
    }
}