package model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class LineTable extends AbstractTableModel {
    private List<InvoiceLine> Lines;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public List<InvoiceLine> getLines() {
        return Lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        Lines = lines;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    public LineTable(java.util.List<InvoiceLine> Lines) {
        this.Lines = Lines;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return Lines;
    }


    @Override
    public int getRowCount() {
        return Lines.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int colInd) {
        switch (colInd) {
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Count";
            case 3:
                return "Line Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int colInd) {
        switch (colInd) {
            case 0:
                return String.class;
            case 1:
            case 3:
                return Double.class;
            case 2:
                return Integer.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row = Lines.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return row.getName();
            case 1:
                return row.getPrice();
            case 2:
                return row.getCount();
            case 3:
                return row.getLineTotal();
            default:
                return "";
        }

    }

}
