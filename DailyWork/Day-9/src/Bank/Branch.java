package Bank;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchName;
    private String manager;
    private String branchNumber;
    private String ifscCode;
    private String pinCode;
    private List<Customer> customers = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public Branch(String branchName, String manager, String branchNumber, String ifscCode, String pinCode) {
        this.branchName = branchName;
        this.manager = manager;
        this.branchNumber = branchNumber;
        this.ifscCode = ifscCode;
        this.pinCode = pinCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}