import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal originalPrice;
    private BigDecimal redPencilPrice;
    private int durationOfPromotion;
    private int durationOfRedPencil;

    public RedPencil(String originalPrice) {
        this.originalPrice = new BigDecimal(originalPrice);
        this.durationOfPromotion = 0;
    }

    public double getOriginalPrice(){
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

    public boolean checkFor30StableOriginalPrice(){
        if(durationOfPromotion >= 30){
            System.out.println("originalPrice stable");
            return true;
        }
        else{
            System.out.println("originalPrice not stable");
            return false;
        }
    }

    public double reduceOriginalPrice(String reductionPercentage){
        BigDecimal percentToReduceBy = new BigDecimal(reductionPercentage);


        if(checkFor30StableOriginalPrice() && checkIfPercentageIsInBounds(percentToReduceBy.doubleValue())){
            BigDecimal percentageOfOriginalPrice = originalPrice.multiply(percentToReduceBy);
            updateRedPencilPrice(percentageOfOriginalPrice);
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

    private boolean checkIfPercentageIsInBounds(double value){
        if(value >= .05 && value <= .30){
            return true;
        }
        else{
            return false;
        }
    }

    private void updateRedPencilPrice(BigDecimal value){
        redPencilPrice = originalPrice.subtract(value);
    }

    

}
