public class Invoice {
    //Adding properties
    int id;
    String description;
    int quantity;
    double unitPrice;
    boolean paid;

    //Constructor
    Invoice(int theID, String desc, int q, double unitsPrice){
        id = theID;
        description = desc;
        quantity = q;
        unitPrice = unitsPrice;
        paid = false;
    }



    //toString method which overrides the original toString method
    //which would print just the hash codes of the objects and would look something like this: Invoice@36baf30c
    public String toString(){
        return "InvoiceItem[id=" + id + ", description=" + description + ", quantity=" + quantity + ", unitPrice=£" + unitPrice + ", paid=" + paid + "]";
    }

    //Using getter and setter methods for paid
    //Getter Method
    public boolean getPaid(){
        return paid;
    }

    //Setter Method
    public boolean setPaid(boolean isPaid){
        paid = isPaid;
        return paid;
    }
}
