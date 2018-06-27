package pl.springDemo.demo.userPayment;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserPaymentService {
    void createStartDate(long userId);
    void createEndDate(long userId);
    boolean hasUserTicket(long userId);
    double calculatePayment(long userId);
    BigDecimal findPaymentSum(LocalDate date);
}
