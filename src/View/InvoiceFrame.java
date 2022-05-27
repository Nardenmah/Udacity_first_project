package view;
import controller.InvoiceListener;
import model.InvoiceHeader;
import model.InvoiceTable;
import model.LineTable;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceFrame extends JFrame {
    public static void main(String args[]) {

        new InvoiceFrame().setVisible(true);
    }
    private JButton createInvoiceButton;
    private JButton createLineButton;
    private JTextField customerNameTextField;
    private JButton deleteInvoiceButton;
    private JButton deleteLineButton;
    private JTextField invoiceDateTextField;
    private JTable invoiceLinesTable;
    private JLabel invoiceNumberLabel;
    private JLabel invoiceTotalLabel;
    private JTable invoicesTable;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JMenu Menu1;
    private JMenuBar MenuBar1;
    private JScrollPane ScrollPane1;
    private JScrollPane ScrollPane2;
    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;

    private List<InvoiceHeader> invoices = new ArrayList<>();
    private InvoiceTable invoiceHeaderTable;
    private LineTable invoiceLinesTableModel;
    private InvoiceText headerText;
    private LineText lineText;
    private InvoiceListener listener = new InvoiceListener(this);

    public InvoiceFrame() {
        Frame();
    }

    private void Frame() {



        ScrollPane1 = new JScrollPane();
        invoicesTable = new JTable();

        createInvoiceButton = new JButton();
        createInvoiceButton.addActionListener(listener);
        deleteInvoiceButton = new JButton();
        deleteInvoiceButton.addActionListener(listener);
        Label1 = new JLabel();
        Label2 = new JLabel();
        Label3 = new JLabel();
        Label4 = new JLabel();
        customerNameTextField= new JTextField();
        invoiceDateTextField = new JTextField();
        invoiceNumberLabel = new JLabel();
        invoiceTotalLabel = new JLabel();
        ScrollPane2 = new JScrollPane();
        invoicesTable = new JTable();
        createLineButton = new JButton();
        createLineButton.addActionListener(listener);
        deleteLineButton = new JButton();
        deleteLineButton.addActionListener(listener);
        MenuBar1 = new JMenuBar();
        Menu1 = new JMenu();
        loadMenuItem = new JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new JMenuItem();
        saveMenuItem.addActionListener(listener);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        ScrollPane1.setViewportView(invoicesTable);
        createInvoiceButton.setText("Create New Invoice");
        deleteInvoiceButton.setText("Delete Invoice");
        Label1.setText("Invoice Number");
        Label2.setText("Invoide Date");
        Label3.setText("Customer name");
        Label4.setText("Invoice Total");

        ScrollPane2.setViewportView(invoiceLinesTable);
        createLineButton.setText("Create New Line");
        deleteLineButton.setText("Delete Line");
        Menu1.setText("File");
        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        Menu1.add(loadMenuItem);
        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        Menu1.add(saveMenuItem);
        MenuBar1.add(Menu1);
        setJMenuBar(MenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(Label3)
                                                                                        .addComponent(Label1)
                                                                                        .addComponent(Label2)
                                                                                        .addComponent(Label4))
                                                                                .addGap(14, 14, 14)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(customerNameTextField)
                                                                                        .addComponent(invoiceDateTextField)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(invoiceNumberLabel)
                                                                                                        .addComponent(invoiceTotalLabel))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addComponent(createLineButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(deleteLineButton)
                                                                .addGap(100, 100, 100))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(createInvoiceButton)
                                                .addGap(80, 80, 80)
                                                .addComponent(deleteInvoiceButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label1)
                                                        .addComponent(invoiceNumberLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label2)
                                                        .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label3)
                                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label4)
                                                        .addComponent(invoiceTotalLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(createLineButton)
                                                        .addComponent(deleteLineButton))
                                                .addGap(44, 44, 44)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteInvoiceButton)
                                        .addComponent(createInvoiceButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }


    public JButton getCreateInvoiceButton() {
        return createInvoiceButton;
    }

    public void setCreateInvoiceButton(JButton createInvoiceButton) {
        this.createInvoiceButton = createInvoiceButton;
    }

    public JButton getCreateLineButton() {
        return createLineButton;
    }

    public void setCreateLineButton(JButton createLineButton) {
        this.createLineButton = createLineButton;
    }

    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }

    public void setCustomerNameTextField(JTextField customerNameTextField) {
        this.customerNameTextField = customerNameTextField;
    }

    public JButton getDeleteInvoiceButton() {
        return deleteInvoiceButton;
    }

    public void setDeleteInvoiceButton(JButton deleteInvoiceButton) {
        this.deleteInvoiceButton = deleteInvoiceButton;
    }

    public JButton getDeleteLineButton() {
        return deleteLineButton;
    }

    public void setDeleteLineButton(JButton deleteLineButton) {
        this.deleteLineButton = deleteLineButton;
    }

    public JTextField getInvoiceDateTextField() {
        return invoiceDateTextField;
    }

    public void setInvoiceDateTextField(JTextField invoiceDateTextField) {
        this.invoiceDateTextField = invoiceDateTextField;
    }

    public JTable getInvoiceLinesTable() {
        return invoiceLinesTable;
    }

    public void setInvoiceLinesTable(JTable invoiceLinesTable) {
        this.invoiceLinesTable = invoiceLinesTable;
    }

    public JLabel getInvoiceNumberLabel() {
        return invoiceNumberLabel;
    }

    public void setInvoiceNumberLabel(JLabel invoiceNumberLabel) {
        this.invoiceNumberLabel = invoiceNumberLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public void setInvoiceTotalLabel(JLabel invoiceTotalLabel) {
        this.invoiceTotalLabel = invoiceTotalLabel;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public void setInvoicesTable(JTable invoicesTable) {
        this.invoicesTable = invoicesTable;
    }

    public JLabel getLabel1() {
        return Label1;
    }

    public void setLabel1(JLabel label1) {
        Label1 = label1;
    }

    public JLabel getLabel2() {
        return Label2;
    }

    public void setLabel2(JLabel label2) {
        Label2 = label2;
    }

    public JLabel getLabel3() {
        return Label3;
    }

    public void setLabel3(JLabel label3) {
        Label3 = label3;
    }

    public JLabel getLabel4() {
        return Label4;
    }

    public void setLabel4(JLabel label4) {
        Label4 = label4;
    }

    public JMenu getMenu1() {
        return Menu1;
    }

    public void setMenu1(JMenu menu1) {
        Menu1 = menu1;
    }

    public JMenuBar getMenuBar1() {
        return MenuBar1;
    }

    public void setMenuBar1(JMenuBar menuBar1) {
        MenuBar1 = menuBar1;
    }

    public JScrollPane getScrollPane1() {
        return ScrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        ScrollPane1 = scrollPane1;
    }

    public JScrollPane getScrollPane2() {
        return ScrollPane2;
    }

    public void setScrollPane2(JScrollPane scrollPane2) {
        ScrollPane2 = scrollPane2;
    }

    public JMenuItem getLoadMenuItem() {
        return loadMenuItem;
    }

    public void setLoadMenuItem(JMenuItem loadMenuItem) {
        this.loadMenuItem = loadMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public void setSaveMenuItem(JMenuItem saveMenuItem) {
        this.saveMenuItem = saveMenuItem;
    }

    public List<InvoiceHeader> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public InvoiceTable getInvoiceHeaderTable() {
        return invoiceHeaderTable;
    }

    public void setInvoiceHeaderTable(InvoiceTable invoiceHeaderTable) {
        this.invoiceHeaderTable = invoiceHeaderTable;
    }

    public LineTable getInvoiceLinesTableModel() {
        return invoiceLinesTableModel;
    }

    public void setInvoiceLinesTableModel(LineTable invoiceLinesTableModel) {
        this.invoiceLinesTableModel = invoiceLinesTableModel;
    }

    public InvoiceText getHeaderText() {
        return headerText;
    }

    public void setHeaderText(InvoiceText headerText) {
        this.headerText = headerText;
    }

    public LineText getLineText() {
        return lineText;
    }

    public void setLineText(LineText lineText) {
        this.lineText = lineText;
    }

    public InvoiceListener getListener() {
        return listener;
    }

    public void setListener(InvoiceListener listener) {
        this.listener = listener;
    }
}
