package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CM on 01/02/2018.
 */
public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     *
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     *
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size() - 1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>) list).subList(i + 1, lastIndex + 1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     *
     * @param period the Period addition
     * @param list   the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }

    public BigDecimal calculate(Period periodStay, CarParkKind kind) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal baseCost = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));
        double base = baseCost.doubleValue();
        BigDecimal finalCost = null;


        //If Student
        if (kind == CarParkKind.STUDENT) {
            BigDecimal fiveFifty = new BigDecimal(5.50);
            BigDecimal seventyFivePercent = new BigDecimal(0.75);
            //If less than 5.50, return baseCost
            if(baseCost.compareTo(fiveFifty) <= 0){
                return baseCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
            //Else, return the discounted price at 25% discount above 5.50
            else{
                return baseCost.subtract(fiveFifty).multiply(seventyFivePercent).add(fiveFifty).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }

        }

        //If Visitor
        if (kind == CarParkKind.VISITOR) {
            //If baseCost is less than 8, Cost is free
            if (base <= 8) {
                finalCost = new BigDecimal(0);
            }
            //Else, finalCost is reduced by 8 and 50% discount on the remainder
            else {
                finalCost = new BigDecimal((base - 8));
                finalCost = finalCost.divide(new BigDecimal(2));
                return finalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
        }

        //If Management
        else if (kind == CarParkKind.MANAGEMENT) {
            //If base cost is less than 3, payment should be 3
            if (base <= 3) {
                finalCost = new BigDecimal(3);
                return finalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
            //Otherwise, require regular payment
            else {
                finalCost = baseCost;
                return finalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
        }

        //If Staff
        if (kind == CarParkKind.STAFF) {
            BigDecimal maxPay = new BigDecimal(16);

            //If base cost is less than 16, return base cost
            if(baseCost.compareTo(maxPay) <= 0){
                return baseCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
            // Else return the maximum payable of 16
            else{
                return maxPay;
            }
        }

        return finalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

}
