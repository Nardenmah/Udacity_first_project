package Controller;



import model.InvoiceHeader;

import model.InvoiceLine;

import javax.swing.*;

import java.io.*;

import java.util.ArrayList;

public class InvoiceListener {
    JFrame frame = new JFrame();
    ArrayList<InvoiceLine> items = new ArrayList<InvoiceLine>() ;
    ArrayList <InvoiceHeader> customer = new ArrayList<InvoiceHeader>();
    ArrayList<String> result = new ArrayList<>();
    public InvoiceListener() {
    }

    public void writefile(){
        try{
            FileOutputStream writeData = new FileOutputStream("customer.cvs");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(customer);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData = new FileInputStream("customer.cvs");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList people2 = (ArrayList< InvoiceHeader >) readStream.readObject();
            readStream.close();

            System.out.println(people2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readfile() {
        try{
            FileInputStream readData = new FileInputStream("customer.cvs");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<InvoiceHeader> people2 = (ArrayList<InvoiceHeader>) readStream.readObject();
            readStream.close();
            System.out.println(people2.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void loadFile(JFrame Frame) {

          this.frame=frame;

        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try {
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerLine = null;

                while ((headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];
                    ;

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
                        InvoiceHeader header = new InvoiceHeader();
                        InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                }
                System.out.println("Check");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


}}