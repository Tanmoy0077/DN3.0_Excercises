public class App {
    public static void main(String[] args) {
        // Create a stock market instance (subject)
        StockMarket stockMarket = new StockMarket();
        
        // Create observer instances
        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        // Register observers with the stock market
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        // Update stock price and notify observers
        System.out.println("Updating stock price to Rs. 100.0");
        stockMarket.setStockPrice(100.0);

        // Deregister one observer and update the stock price again
        stockMarket.deregisterObserver(mobileApp2);
        System.out.println("Updating stock price to Rs. 150.0");
        stockMarket.setStockPrice(150.0);
    }
}
