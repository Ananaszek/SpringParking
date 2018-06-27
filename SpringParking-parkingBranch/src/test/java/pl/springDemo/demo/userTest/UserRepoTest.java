package pl.springDemo.demo.userTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.springDemo.demo.user.User;
import pl.springDemo.demo.user.UserRepo;
import pl.springDemo.demo.user.UserType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void whenFindUserId_thenReturnUserType(){

        //given
        User user = new User("login1",UserType.DRIVER);
        entityManager.persist(user);
        entityManager.flush();

        //when
        UserType type = userRepo.findUserTypeById(user.getId());

        //then
        assertThat(type).isEqualTo(user.getUserType());
    }
}
