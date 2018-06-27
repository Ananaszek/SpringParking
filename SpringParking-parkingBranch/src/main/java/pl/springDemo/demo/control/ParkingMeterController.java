package pl.springDemo.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.springDemo.demo.userPayment.UserPaymentService;

@RestController
@RequestMapping("/parkingMeter")
public class ParkingMeterController {

    private final UserPaymentService userPaymentService;

    @Autowired
    public ParkingMeterController(UserPaymentService userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @PostMapping("/start/{id}")
    public void start(@PathVariable("id") String id){
        long userPaymentId = Long.parseLong(id);
        userPaymentService.createStartDate(userPaymentId);
    }

    @PostMapping("/end/{id}")
    public void end(@PathVariable("id") String id){
        long userPaymentId = Long.parseLong(id);
        userPaymentService.createEndDate(userPaymentId);
    }
}
