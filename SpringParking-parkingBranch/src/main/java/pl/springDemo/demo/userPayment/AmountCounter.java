package pl.springDemo.demo.userPayment;

import pl.springDemo.demo.user.UserType;

public class AmountCounter {

    public double countHoursAmount(UserType userType, long hours) {
        switch (userType) {
            case VIP_DRIVER:
                if (hours <= 1) {
                    return 0;
                } else if (hours == 2) {
                    return 2;
                } else {
                    for (int i = 0; i < hours; i++) {
                        double a = 2 * 1.5;
                        return (a * 1.5);
                    }
                }
                break;

            case DRIVER:
                if (hours <= 1) {
                    return 1;
                } else if (hours == 2) {
                    return 3;
                } else {
                    for (int i = 0; i <= hours; i++) {
                        double b = 3 * 2;
                        return (b * 2);
                    }
                }
                break;

        }

        return 0;
    }
}
