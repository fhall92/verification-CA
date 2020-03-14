package cm;

import java.math.BigDecimal;

 class VisitorCalculation extends Calculation {

    public BigDecimal calculation(BigDecimal baseCost){
        BigDecimal finalCost;

        //If baseCost < 8, final cost is free
        if (baseCost.compareTo(new BigDecimal(8)) <= 0) {
            finalCost = new BigDecimal(0);
        }
        //Else, finalCost is reduced by 8 and 50% discount on the remainder
        else {
            finalCost = baseCost.subtract(new BigDecimal(8));
            finalCost = finalCost.divide(new BigDecimal(2));
        }

        return finalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

}
