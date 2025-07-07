class Customer {
    private final String customerId;
    private String name;
    private Plan plan;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    @Override
    public String toString() {
        return "Customer{" + name + ", ID=" + customerId + '}';
    }
}