//receipt objects

package nour.ppts;

import java.util.ArrayList;

public class Reciept implements Printable {
    //public void print(){}

    private int id;
    //private date issueDate;
    private ArrayList<Product> products = new ArrayList<>();
    private float total;

    public static ArrayList<Reciept> allReciepts = new ArrayList<>();

}
