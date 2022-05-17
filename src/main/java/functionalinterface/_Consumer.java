package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        //Normal Java function
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);

        //Consumer Functional interface
        greetCustomerConsumer.accept(maria);
    }

    static Consumer<Customer> greetCustomerConsumer =
            customer ->
                    System.out.println("Hello " + customer.name +
                            ", thanks for registering phone number " +
                            customer.phoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name +
                ", thanks for registering phone number " +
                customer.phoneNumber);
    }


    static class Customer {
        private final String name;
        private final String  phoneNumber;


        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
