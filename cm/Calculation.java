package cm;

import java.math.BigDecimal;

class Calculation {

    BigDecimal calculation(BigDecimal baseCost) {
        return baseCost;
    }

    Calculation calcType(CarParkKind kind) {
        Calculation calcType;

        switch (kind) {
            case STUDENT:
                calcType = new StudentCalculation();
                break;

            case VISITOR:
                calcType = new VisitorCalculation();
                break;

            case STAFF:
                calcType = new StaffCalculation();
                break;

            case MANAGEMENT:
                calcType = new ManagementCalculation();
                break;

            default:
                calcType = null;
                break;
        }

        return calcType;
    }

}
