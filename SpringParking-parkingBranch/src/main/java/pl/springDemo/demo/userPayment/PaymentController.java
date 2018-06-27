package pl.springDemo.demo.userPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final UserPaymentService userPaymentService;

    @Autowired
    public PaymentController(UserPaymentService userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @GetMapping("/amount/{id}")
    public double printPayment(@PathVariable("id") String id){
        long userId = Long.parseLong(id);
        return userPaymentService.calculatePayment(userId);
    }

    @GetMapping(value = "/sum/{date}")
    public BigDecimal findDailySum(@PathVariable("date") String date){
        LocalDate sumDate = LocalDate.parse(date);
        return userPaymentService.findPaymentSum(sumDate);
    }
}
