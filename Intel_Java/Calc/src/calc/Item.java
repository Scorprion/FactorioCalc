package calc;

/**
 * Created by Dylan Choi on 6/12/2017.
 */

public class Item {
    public int Id;
    public String ItemName;
    public String Equation;
    public int Ct;
    public Item(int id, String item_name, String equation, int ct) {
        this.Id = id;
        this.ItemName = item_name;
        this.Equation = equation;
        this.Ct = ct;
    }
}