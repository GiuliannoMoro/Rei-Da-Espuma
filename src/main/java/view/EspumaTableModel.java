package view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import model.ConsultaServico;

public class EspumaTableModel extends AbstractTableModel {

    private ArrayList<ConsultaServico> lista;

    private String[] colunas = {
        "Cliente",
        "Placa",
        "Veículo",
        "Serviço",
        "Adicionais",
        "Valor"
    };

    public EspumaTableModel(ArrayList<ConsultaServico> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ConsultaServico c = lista.get(rowIndex);

        switch(columnIndex) {
            case 0: return c.getCliente();
            case 1: return c.getPlaca();
            case 2: return c.getVeiculo();
            case 3: return c.getTipoServico();
            case 4: return c.getAdicionais();
            case 5: return "R$ " + String.format("%.2f", c.getValor());
            default: return null;
        }
    }

    public int getIdAt(int rowIndex) {
        return lista.get(rowIndex).getId();
    }
}