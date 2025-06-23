package Assignment_5;

class CallRecord {
    private final String number;
    private final int duration;

    public CallRecord(String number, int duration) {
        this.number = number;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Number: " + number + ", Duration: " + duration + " sec";
    }
}
