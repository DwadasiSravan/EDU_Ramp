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