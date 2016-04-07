import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal originalPrice;
    private BigDecimal redPencilPrice;
    private int durationOfPromotion;
    private int durationOfRedPencil;

    public RedPencil(String originaloriginalPrice) {
        this.originalPrice = new BigDecimal(originaloriginalPrice);
        this.durationOfPromotion = 0;
    }

    public double getoriginalPrice(){
        System.out.println("originalPrice");
        return originalPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public int getDuration(){
        return durationOfPromotion;
    }

    public void addDaysOfDuration(int duration){
        durationOfPromotion += duration;
    }

    private void resetDuration(){
        durationOfPromotion = 0;
    }

    public boolean checkFor30StableoriginalPrice(){
        if(durationOfPromotion >= 30){
            System.out.println("originalPrice stable");
            return true;
        }
        else{
            System.out.println("originalPrice not stable");
            return false;
        }
    }

    public double reduceoriginalPrice(String reductionPercentage){
        BigDecimal percentToReduceBy = new BigDecimal(reductionPercentage);

        if(checkFor30StableoriginalPrice()){
            if(percentToReduceBy.doubleValue() >= .05 && percentToReduceBy.doubleValue() <= .30){
                BigDecimal percentageOfOriginalPrice = originalPrice.multiply(percentToReduceBy);
                redPencilPrice = originalPrice.subtract(percentageOfOriginalPrice);
            }
            System.out.println("originalPrice: $" + originalPrice);
            return redPencilPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
        else{
            System.out.println("originalPrice cannot be reduced because the previous originalPrice hasn't been stable for 30 days");
            System.out.println("originalPrice: $" + originalPrice);
            return originalPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
    }

    public void addDaysToRedPencilDuration(int numberOfDays){
        durationOfRedPencil += numberOfDays;
    }

    

}
