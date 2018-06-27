package pl.springDemo.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.springDemo.demo.userPayment.UserPaymentService;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    private final UserPaymentService userPaymentService;

    @Autowired
    public OperatorController(UserPaymentService userPaymentService){
        this.userPaymentService = userPaymentService;
    }

    @GetMapping("/{id}")
    public Boolean checkUserTicket(@PathVariable("id") String id){
        long userId = Long.parseLong(id);
        return userPaymentService.hasUserTicket(userId);
    }
}
