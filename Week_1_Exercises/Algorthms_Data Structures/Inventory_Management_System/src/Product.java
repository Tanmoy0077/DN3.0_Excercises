public class Product{

    public int productId;
    public String productName;
    public int quantity;
    public int price;

    Product(int productId, String productName, int quantity, int price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + 
               ", Quantity: " + quantity + ", Price: Rs. " + price;
    }
}