package pl.springDemo.demo.userPaymentTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.springDemo.demo.user.UserType;
import pl.springDemo.demo.userPayment.UserPayment;
import pl.springDemo.demo.userPayment.UserPaymentRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserPaymentRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserPaymentRepo userPaymentRepo;

    @Test
    public void whenFindDateFrom_thenReturnUserPayment(){

        //given
        UserPayment userPayment = new UserPayment(1,LocalDateTime.now(),LocalDateTime.now().plusHours(1),LocalDate.now(),1,UserType.DRIVER);
        entityManager.persist(userPayment);
        entityManager.flush();

        //when
        UserPayment found = userPaymentRepo.findUserWithStartDate().get(0);

        //then
        assertThat(found).isEqualTo(userPayment);
    }

    @Test
    public void whenFindId_thenReturnDateFrom(){
        //given
        UserPayment userPayment = new UserPayment(1,LocalDateTime.now(),LocalDateTime.now().plusHours(1),LocalDate.now(),1,UserType.DRIVER);
        entityManager.persist(userPayment);
        entityManager.flush();

        //when
        LocalDateTime from = userPaymentRepo.findDateFromById(userPayment.getUserId());

        //then
        assertThat(from).isEqualTo(userPayment.getDateFrom());
    }
}
