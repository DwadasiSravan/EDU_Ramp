public class Call {
    private final String toNumber;
    private final int duration;

    public Call(String toNumber, int duration) {
        this.toNumber = toNumber;
        this.duration = duration;
    }

    public String getToNumber() {
        return toNumber;
    }

    public int getDuration() {
        return duration;
    }
}
