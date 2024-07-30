

public class DependencyInjection {
    public static void main(String[] args) {
        var customerRepoImpl = new CustomerRepositoryImpl();
        var customerService = new CustomerService(customerRepoImpl);
        var customerDetails = customerService.getCustomerDetails("1");
        System.out.println("Customer Details: " + customerDetails);
    }
}



interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        if (id.equals("1")) {
            return "John Doe";
        } else {
            return "Customer not found";
        }
    }
}

class CustomerService {
    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public String getCustomerDetails(String id) {
        return customerRepo.findCustomerById(id);
    }
}