public class App {
    public static void main(String[] args) {
        // Create a proxy image
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");
        
        // Display images
        // The image is loaded and displayed for the first time
        image1.display();
        // The image is already loaded, so it's only displayed
        image1.display();
        
        // The image is loaded and displayed for the first time
        image2.display();
        // The image is already loaded, so it's only displayed
        image2.display();
    }
}
