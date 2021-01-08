package nour.ppts;

public interface Printable {
    void printOne(Medicine medicine);
    void printOne(OtherProduct product);
    void printOne(Receipt receipt);
    
    void printTable(javax.swing.JTable table);
}