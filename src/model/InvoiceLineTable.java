package model;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceLineTable extends JFrame {
    private List<InvoiceLine> Lines;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceLineTable(java.util.List<InvoiceLine> Lines) {
        this.Lines = Lines;
    }
  public JComponent LinesTable() {
      String cols1[] = {"No", "item name", "item price", "count", "itemTotal"};
      String rows1[][] = new String[1000][1000];
      for (int i = 0; i <= Lines.size(); i++)
          for (int j = 0; j < 5; j++) {
              try {
                  rows1[i][j] = String.valueOf(new String[]{String.valueOf((i)),
                          String.valueOf(Lines.get(0).getName()),
                          String.valueOf(Lines.get(i).getPrice()), String.valueOf(Lines.get(i).getCount())
                          , String.valueOf(Lines.get(i).getLineTotal())});
              } catch (Exception a) {
              }
          }
      JComponent Linestable = new JTable(rows1,cols1);
      return Linestable;
  }
}
