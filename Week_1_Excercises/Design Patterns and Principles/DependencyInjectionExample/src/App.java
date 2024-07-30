public class App {
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.getCustomerById("12345");
        System.out.println(customer);
    }
}
