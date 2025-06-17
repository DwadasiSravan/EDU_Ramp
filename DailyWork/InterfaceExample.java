interface StreamingService {
    void playContent(String contentName);
}

interface Subscription {
    void subscribe(String plan);
}

class Platform {
    void showPlatformInfo() {
        System.out.println("This is a streaming platform.");
    }
}

class OTTPlatform extends Platform {
    void showOTTInfo() {
        System.out.println("This is an OTT platform.");
    }
}

class Hotstar extends OTTPlatform implements StreamingService, Subscription {
    @Override
    public void playContent(String contentName) {
        System.out.println("Streaming '" + contentName + "' on Hotstar.");
    }

    @Override
    public void subscribe(String plan) {
        System.out.println("Subscribed to Hotstar with " + plan + " plan.");
    }
}

class Netflix extends OTTPlatform implements StreamingService, Subscription {
    @Override
    public void playContent(String contentName) {
        System.out.println("Streaming '" + contentName + "' on Netflix.");
    }

    @Override
    public void subscribe(String plan) {
        System.out.println("Subscribed to Netflix with " + plan + " plan.");
    }
}


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