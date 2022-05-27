package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class LineText extends JDialog{
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okButton;
    private JButton cancelButton;

    public LineText(view.InvoiceFrame frame) {
        itemNameField = new JTextField(25);
        itemNameLabel = new JLabel("Item Name");

        itemCountField = new JTextField(25);
        itemCountLabel = new JLabel("Item Count");

        itemPriceField = new JTextField(25);
        itemPriceLabel = new JLabel("Item Price");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("createLineOK");
        cancelButton.setActionCommand("createLineCancel");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));

        add(itemNameLabel);
        add(itemNameField);
        add(itemCountLabel);
        add(itemCountField);
        add(itemPriceLabel);
        add(itemPriceField);
        add(okButton);
        add(cancelButton);

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }

    public void setItemNameField(JTextField itemNameField) {
        this.itemNameField = itemNameField;
    }

    public void setItemCountField(JTextField itemCountField) {
        this.itemCountField = itemCountField;
    }

    public void setItemPriceField(JTextField itemPriceField) {
        this.itemPriceField = itemPriceField;
    }

    public JLabel getItemNameLabel() {
        return itemNameLabel;
    }

    public void setItemNameLabel(JLabel itemNameLabel) {
        this.itemNameLabel = itemNameLabel;
    }

    public JLabel getItemCountLabel() {
        return itemCountLabel;
    }

    public void setItemCountLabel(JLabel itemCountLabel) {
        this.itemCountLabel = itemCountLabel;
    }

    public JLabel getItemPriceLabel() {
        return itemPriceLabel;
    }

    public void setItemPriceLabel(JLabel itemPriceLabel) {
        this.itemPriceLabel = itemPriceLabel;
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