package pl.springDemo.demo.userPayment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.springDemo.demo.user.User;
import pl.springDemo.demo.user.UserType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "UserPayment")
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    private long userId;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private LocalDate date;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    public UserPayment(long userId, LocalDateTime dateFrom, LocalDateTime dateTo, LocalDate date, Integer amount, UserType userType) {
        this.userId = userId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.date = date;
        this.amount = amount;
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPayment that = (UserPayment) o;
        return id == that.id &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
