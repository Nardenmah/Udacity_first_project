package controller;
import view.InvoiceFrame;
import model.InvoiceHeader;
import model.InvoiceTable;
import model.InvoiceLine;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceListener implements ActionListener {
    private InvoiceFrame frame;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceListener(InvoiceFrame frame) {
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "LoadFile":
                try {
                    loadFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
            case "SaveFile":
                try {
                    saveData();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    private void loadFile() throws IOException, ParseException {
        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();

                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerLine = null;

                while ((headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];

                    int invNum = Integer.parseInt(invNumStr);
                    Date invDate = df.parse(invDateStr);

                    InvoiceHeader inv = new InvoiceHeader( custName, invDate,invNum);
                    frame.getInvoices().add(inv);
                }

                JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];

                        int invNum = Integer.parseInt(invNumStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int itemCount = Integer.parseInt(itemCountStr);
                        InvoiceHeader header = findInvoiceByNum(invNum);
                        InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                    frame.setInvoicesTable(new JTable(new InvoiceTable(frame.getInvoices())));
                    frame.getInvoicesTable().setModel(frame.getInvoiceHeaderTable());
                    frame.getInvoicesTable().validate();
                }
                System.out.println("Check");
            }
    }

    private void saveData() throws IOException {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : frame.getInvoices()) {
            headers += header.getDataCustomer();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataInvoice();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please, select file to save header data!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();

                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(headers);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(lines);
                    lFW.flush();
                    lFW.close();}
        }
    }

    private InvoiceHeader findInvoiceByNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : frame.getInvoices()) {
            if (invNum == inv.getInvoiceNumber()) {
                header = inv;
                break;
            }
        }
        return header;
    }


}