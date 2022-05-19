package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private String name;
    private Date date;
    private int invoiceNumber;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader() {
    }

    public InvoiceHeader(String name, Date date, int invoiceNumber) {
        this.name = name;
        this.date = date;
        this.invoiceNumber = invoiceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", invoiceNumber=" + invoiceNumber +
                ", lines=" + lines +
                '}';
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public double getInvTotal() {
        double total = 0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }

    public void addInvoiceLine(InvoiceLine line) {
        getLines().add(line);
    }

    public String getDataCustomer() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceNumber() + "," + df.format(getDate()) + "," + getName();
    }

}
