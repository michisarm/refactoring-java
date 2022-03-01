public class Controller {
    public static void main(String[] args) {
        Customer aCustomer= new Customer("고객1");
        String message = aCustomer.statement();
        System.out.println(message);
    }
}
