public class PaymentGatewayBAdapter implements PaymentProcessor {
    private PaymentGatewayB paymentGatewayB;

    public PaymentGatewayBAdapter(PaymentGatewayB paymentGatewayB) {
        this.paymentGatewayB = paymentGatewayB;
    }

    @Override
    public void processPayment(double amount) {
        paymentGatewayB.executeTransaction(amount);
    }
}