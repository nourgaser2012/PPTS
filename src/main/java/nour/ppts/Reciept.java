//receipt objects
//OMAR'S TASK

//this should contain all the setters and the getters for the reciept data
//it should also contain the attributes of the reciept
//should be similar to the Medicine and the OtherProduct classes (check them)

package nour.ppts;

import java.util.ArrayList;

public class Reciept {
    private int id;
    private java.util.Date issueDate;
    private ArrayList<Product> products = new ArrayList<>();
    private float total;

    public static ArrayList<Reciept> allReciepts = new ArrayList<>();

}
//OMAR'S TASK