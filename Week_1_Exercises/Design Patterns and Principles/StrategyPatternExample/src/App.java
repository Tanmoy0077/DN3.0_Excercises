public class App {
    public static void main(String[] args) {
        // Create and test Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(150.75);

        // Create and test PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext = new PaymentContext(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}
