package View;
import model.InvoiceHeader;
import model.InvoiceHeaderTable;
import model.InvoiceLine;
import model.InvoiceLineTable;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceFrame extends JFrame {
    private JLabel InVoiceTableName;
    private JButton B1;
    private JButton B2;
    private JLabel InvoiceNumber;
    private JLabel invoiceDate;
    private JLabel CustomerName1;
    private JTextField InvoiceDate;
    private JTextField CustomerName;
    private JLabel InvoiceTotal;
    private JLabel InvoiceTableName2;
    private JButton B3;
    private JButton B4;
    private JScrollPane jScrollPane2 ;
    private JScrollPane jScrollPane1;

    public InvoiceFrame() {
        Frame();
    }

    public void Frame() {
        JFrame frame = new JFrame();
       List<InvoiceHeader> invoices = new ArrayList<>();
        InvoiceHeaderTable HeaderTable = new InvoiceHeaderTable(invoices);
        List<InvoiceLine> Lines = new ArrayList<>();
        InvoiceLineTable LineTable = new InvoiceLineTable(Lines);
        menuBar jmenuBar = new menuBar();
        frame.setTitle("Design preview [JFrame]");

        B1 = new JButton(" Create new Invoice");
        B2 = new JButton("Delete Invoice");
        invoiceDate = new JLabel("invoice Date");
        InvoiceDate = new JTextField(10);
        CustomerName1 = new JLabel("Customer name");
        CustomerName = new JTextField(10);
        InvoiceTotal = new JLabel("InvoiceTotal");
        InVoiceTableName = new JLabel("Invoices Table");
        B3 = new JButton("save");
        B4 = new JButton("CANCEL");
        jScrollPane2 = new JScrollPane();
        jScrollPane1 = new JScrollPane();
        frame.setJMenuBar((JMenuBar) jmenuBar.menuBar());
        setLayout(new FlowLayout());
        frame.setSize(200,200);
        frame.setLocation(50,50);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        Panel panel1 = new Panel();
        panel1.add(InVoiceTableName);
        panel1.add(HeaderTable.HeaderTable());
        panel1.add(B1);
        panel1.add(B2);
        Panel panel2 = new Panel();
        panel2.add(InvoiceNumber);
        panel2.add(invoiceDate);
        panel2.add(InvoiceDate) ;
        panel2.add(CustomerName1);

        panel2.add( CustomerName);
        panel2.add (InvoiceTotal);
        panel2.add(InvoiceTableName2);
        panel2.add(LineTable.LinesTable());
        panel2.add(B3);
        panel2.add(B4);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
        pack();

    }
}
