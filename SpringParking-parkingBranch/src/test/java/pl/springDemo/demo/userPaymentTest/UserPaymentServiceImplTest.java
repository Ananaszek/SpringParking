package pl.springDemo.demo.userPaymentTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.springDemo.demo.user.UserType;
import pl.springDemo.demo.userPayment.AmountCounter;
import pl.springDemo.demo.userPayment.UserPayment;
import pl.springDemo.demo.userPayment.UserPaymentService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
public class UserPaymentServiceImplTest {

    private UserPaymentService userPaymentService;
    private AmountCounter amountCounter;

    @Before
    public void prepare(){
        userPaymentService = mock(UserPaymentService.class);
        amountCounter = mock(amountCounter.getClass());
    }

    @Test
    public void checkUserTicket(){
        //given
        UserPayment userPayment = new UserPayment(1,LocalDateTime.now(),LocalDateTime.now().plusHours(1),LocalDate.now(),1,UserType.DRIVER);

        //when
        boolean hasTicket = userPaymentService.hasUserTicket(userPayment.getUserId());

        //then
        Assert.assertTrue(hasTicket);
    }

    @Test
    public void calculatePaymentTest(){
        //given
        UserPayment userPayment = new UserPayment(2,null,null,null,0,UserType.VIP_DRIVER);

        //when
        double paymentAmount = userPaymentService.calculatePayment(userPayment.getUserId());

        //then
        assertThat(paymentAmount).isEqualTo(userPayment.getAmount());
    }
}
