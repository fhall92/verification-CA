package cm;

import java.math.BigDecimal;

class StudentCalculation extends Calculation{

    BigDecimal calculation(BigDecimal baseCost){
        BigDecimal normalPayLimit = new BigDecimal("5.50");
        BigDecimal reduction = new BigDecimal("0.75");
        //If less than 5.50, return baseCost
        if (baseCost.compareTo(normalPayLimit) <= 0) {
            return baseCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        //Else, return the discounted price at 25% discount above 5.50
        else {
            return baseCost.subtract(normalPayLimit).multiply(reduction).add(normalPayLimit).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }

}