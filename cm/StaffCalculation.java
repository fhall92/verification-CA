package cm;

import java.math.BigDecimal;

class StaffCalculation extends Calculation{

    BigDecimal calculate(BigDecimal baseCost) {
        BigDecimal maxPay = new BigDecimal(16);

        //If base cost is less than 16, return base cost
        if (baseCost.compareTo(maxPay) <= 0) {
            return baseCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        // Else return the maximum payable of 16
        else {
            return maxPay.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
