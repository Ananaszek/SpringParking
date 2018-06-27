package pl.springDemo.demo.userPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.springDemo.demo.user.UserRepo;
import pl.springDemo.demo.user.UserType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    private final UserPaymentRepo userPaymentRepo;
    private final UserRepo userRepo;
    private final AmountCounter amountCounter;

    @Autowired
    public UserPaymentServiceImpl(UserPaymentRepo userPaymentRepo, UserRepo userRepo, AmountCounter amountCounter) {
        this.userPaymentRepo = userPaymentRepo;
        this.userRepo = userRepo;
        this.amountCounter = amountCounter;
    }

    @Override
    public void createStartDate(long userPaymentId) {
        LocalDateTime dateFrom = LocalDateTime.now();
        UserPayment userPayment = userPaymentRepo.findById(userPaymentId).get();
        userPayment.setDateFrom(dateFrom);
        userPaymentRepo.save(userPayment);
    }

    @Override
    public void createEndDate(long userPaymentId) {
        LocalDateTime dateTo = LocalDateTime.now();
        UserPayment userPayment = userPaymentRepo.findById(userPaymentId).get();
        userPayment.setDateTo(dateTo);
        userPaymentRepo.save(userPayment);
    }

    @Override
    public boolean hasUserTicket(long userId) {
        return userPaymentRepo.findUserWithStartDate().contains(userId);
    }

    @Override
    public double calculatePayment(long userId) {
        UserType userType = userRepo.findUserTypeById(userId);
        LocalDateTime start = userPaymentRepo.findDateFromById(userId);
        LocalDateTime end = userPaymentRepo.findDateToById(userId);

        long hours = Duration.between(start,end).toHours();
        double amount = amountCounter.countHoursAmount(userType, hours);

        UserPayment user = userPaymentRepo.findById(userId).get();
        userPaymentRepo.save(user);

        return amount;
    }

    @Override
    public BigDecimal findPaymentSum(LocalDate date) {
        return userPaymentRepo.findDailySum(date);
    }
}
