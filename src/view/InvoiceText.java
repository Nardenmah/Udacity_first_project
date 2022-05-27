package view;



import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceText extends JDialog {
    private JTextField customerNameField;
    private JTextField invoiceDateField;
    private JLabel customerNameLabel;
    private JLabel invoiceDateLabel;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceText(InvoiceFrame frame) {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField(25);
        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(25);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("createInvOK");
        cancelButton.setActionCommand("createInvCancel");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));

        add(invoiceDateLabel);
        add(invoiceDateField);
        add(customerNameLabel);
        add(customerNameField);
        add(okButton);
        add(cancelButton);

        pack();

    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public void setCustomerNameField(JTextField customerNameField) {
        this.customerNameField = customerNameField;
    }

    public JTextField getInvoiceDateField() {
        return invoiceDateField;
    }

    public void setInvoiceDateField(JTextField invoiceDateField) {
        this.invoiceDateField = invoiceDateField;
    }

    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public void setCustomerNameLabel(JLabel customerNameLabel) {
        this.customerNameLabel = customerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public void setInvoiceDateLabel(JLabel invoiceDateLabel) {
        this.invoiceDateLabel = invoiceDateLabel;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}