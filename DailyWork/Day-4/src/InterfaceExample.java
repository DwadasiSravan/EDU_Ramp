public class InterfaceExample {
    public static void main(String[] args) {
        Hotstar hotstar = new Hotstar();
        Netflix netflix = new Netflix();

        hotstar.showPlatformInfo();
        hotstar.showOTTInfo();
        hotstar.subscribe("Premium");
        hotstar.playContent("Cricket Match");

        System.out.println();

        netflix.showOTTInfo();
        netflix.subscribe("Standard");
        netflix.playContent("Stranger Things");
    }
}