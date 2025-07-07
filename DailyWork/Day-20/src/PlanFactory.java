class PlanFactory {
    public static Plan createPlan(String type) {
        if ("Prepaid".equalsIgnoreCase(type)) return new PrepaidPlan();
        if ("Postpaid".equalsIgnoreCase(type)) return new PostpaidPlan();
        throw new IllegalArgumentException("Invalid plan type");
    }
}