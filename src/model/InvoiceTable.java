package model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceTable extends AbstractTableModel {
    private List<InvoiceHeader> invoices;
    private DateFormat Date = new SimpleDateFormat("day-Month-year");

    public InvoiceTable(List<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public List<InvoiceHeader> getInvoices() {
        return invoices;
    }
    @Override
    public int getRowCount() { //initialize row size
        return invoices.size();
    }

    @Override
    public int getColumnCount() { //initialize column size
        return 4;
    }

    @Override
    public String getColumnName(int colInd) { // names of column
        switch (colInd) {
            case 0:
                return "InvoiceNumber";
            case 1:
                return "CustomerName";
            case 2:
                return "InvoiceDate";
            case 3:
                return "Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
                return String.class;
            case 3:
                return Double.class;
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
        InvoiceHeader row = invoices.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return row.getInvoiceNumber();
            case 1:
                return row.getName();
            case 2:
                return Date.format(row.getDate());
            case 3:
                return row.getInvTotal();
            default:
                return "";
        }

    }

    public void setInvoices(List<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public DateFormat getDate() {
        return Date;
    }

    public void setDate(DateFormat date) {
        Date = date;
    }
}
