package pl.springDemo.demo.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query("select e.userType from User e where e.id = :id")
    UserType findUserTypeById(@Param("id") long id);
}
