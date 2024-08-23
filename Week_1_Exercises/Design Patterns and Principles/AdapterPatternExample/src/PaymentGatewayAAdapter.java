public class PaymentGatewayAAdapter implements PaymentProcessor {
    private PaymentGatewayA paymentGatewayA;

    public PaymentGatewayAAdapter(PaymentGatewayA paymentGatewayA) {
        this.paymentGatewayA = paymentGatewayA;
    }

    @Override
    public void processPayment(double amount) {
        paymentGatewayA.makePayment(amount);
    }
}