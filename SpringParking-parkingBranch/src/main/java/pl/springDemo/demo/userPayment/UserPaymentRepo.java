package pl.springDemo.demo.userPayment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Repository
public interface UserPaymentRepo extends CrudRepository<UserPayment,Long> {

    @Query("select e from UserPayment e where e.dateFrom is not null and e.dateTo is null")
    List<UserPayment> findUserWithStartDate();

    @Query("select sum(e.amount) from UserPayment e where e.date = :date ")
    BigDecimal findDailySum(@Param("date") LocalDate date);

    @Query("select e.dateFrom from UserPayment e where e.userId = :userId")
    LocalDateTime findDateFromById(@Param("userId") long userId);

    @Query("select e.dateTo from UserPayment e where e.userId = :userId")
    LocalDateTime findDateToById(@Param("userId") long userId);
}
