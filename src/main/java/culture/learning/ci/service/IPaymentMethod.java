package culture.learning.ci.service;

public interface IPaymentMethod {

    boolean cashPayment();

    boolean mobilePayment();

    boolean cashBack();
}
