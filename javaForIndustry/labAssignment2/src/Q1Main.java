public class Q1Main {
    public static void main(String[] args) {
        //1st instance of Invoice
        Invoice firstInvoice = new Invoice(1, "Doritos", 1, 1.75);
        //Using setter method to change the boolean if the customer has paid
        firstInvoice.setPaid(true);
        System.out.println(firstInvoice);

        //2nd instance of Invoice
        Invoice secondInvoice = new Invoice(2, "KitKat", 8, 2.15);
        //Using setter method to change the boolean if the customer has paid
        secondInvoice.setPaid(true);
        System.out.println(secondInvoice);
    }
}
