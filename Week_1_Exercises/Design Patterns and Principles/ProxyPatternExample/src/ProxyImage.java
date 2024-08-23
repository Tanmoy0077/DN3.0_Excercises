public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean isLoaded = false;

    // Constructor
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!isLoaded) {
            // Load the image from the server
            realImage = new RealImage(filename);
            isLoaded = true;
        }
        // Display the image
        realImage.display();
    }
}