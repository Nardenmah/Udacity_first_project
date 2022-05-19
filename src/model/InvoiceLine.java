package model;

public class InvoiceLine {
private String name;
private double price ;
private int count;
private InvoiceHeader header;

    public InvoiceLine(String name, double price, int count, InvoiceHeader header) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", header=" + header +
                '}';
    }

    public double getLineTotal() {
        return count * price;
    }

    public String getDataInvoice() {
        return "" + getHeader().getInvoiceNumber() + "," + getName() + "," + getPrice() + "," + getCount();
    }
}

