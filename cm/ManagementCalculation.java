package cm;

import java.math.BigDecimal;

public class ManagementCalculation extends Calculation {

    BigDecimal calculation(BigDecimal baseCost) {
        //If base cost is less than 3, payment should be 3
        if (baseCost.compareTo(new BigDecimal(3)) <= 0) {
            BigDecimal cost = new BigDecimal(3);
            return cost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        //Otherwise, require regular payment
        else {
            return baseCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }


}
