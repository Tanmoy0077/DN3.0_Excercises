public class App {
    public static void main(String[] args) throws Exception {
        // Adaptee instances
        PaymentGatewayA paymentGatewayA = new PaymentGatewayA();
        PaymentGatewayB paymentGatewayB = new PaymentGatewayB();

        // Adapters
        PaymentProcessor processorA = new PaymentGatewayAAdapter(paymentGatewayA);
        PaymentProcessor processorB = new PaymentGatewayBAdapter(paymentGatewayB);

        // Process payments using adapters
        processorA.processPayment(100.0);
        processorB.processPayment(200.0);
    }
}
