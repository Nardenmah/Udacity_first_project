package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceHeaderTable extends JFrame {


    private List<InvoiceHeader> invoices;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceHeaderTable(List<InvoiceHeader> invoices) {
        this.invoices = invoices; }

     public JComponent HeaderTable (){
        String cols[] = {"No", "Date", "Customer", "Total"};
    String rows[][] = new String[1000][1000];
        for (int i = 0; i <= invoices.size(); i++)
            for (int j = 0; j < 4; j++) {
        try {
            rows[i][j] = String.valueOf(new String[]{String.valueOf(invoices.get(i).getInvoiceNumber()), String.valueOf(invoices.get(i).getDate()),
                    invoices.get(i).getName(), String.valueOf(invoices.get(i).getInvTotal())});
        }
        catch (Exception o) { }

    }
        JTable HeaderTable = new JTable(rows,cols);
         return HeaderTable;
     }
}