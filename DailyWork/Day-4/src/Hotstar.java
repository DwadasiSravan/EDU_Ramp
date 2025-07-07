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