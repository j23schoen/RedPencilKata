import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal originalPrice;
    private BigDecimal redPencilPrice;
    private double totalReductionPercentage;
    private boolean promotionIsActive;
    private int duration;

    public RedPencil(String originalPrice) {
        this.originalPrice = new BigDecimal(originalPrice);
        this.duration = 0;
    }

    public double getOriginalPrice(){
        System.out.println("originalPrice");
        return originalPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public int getDuration(){
        return duration;
    }

    public void addDaysOfDuration(int numberOfDays){
        duration += numberOfDays;
    }

    private void resetDuration(){
        duration = 0;
    }

    public boolean checkForStability(){
        if(duration >= 30){
            System.out.println("originalPrice stable");
            return true;
        }
        else{
            System.out.println("originalPrice not stable");
            return false;
        }
    }

    public double reduceOriginalPriceByPercentage(String reductionPercentage){
        BigDecimal percentToReduceBy = new BigDecimal(reductionPercentage);

        if(checkForStability() && checkIfPercentageIsInBounds(percentToReduceBy.doubleValue())){
            BigDecimal percentageOfOriginalPrice = originalPrice.multiply(percentToReduceBy);
            totalReductionPercentage += percentToReduceBy.doubleValue();
            updateRedPencilPrice(percentageOfOriginalPrice);
            resetDuration();
            promotionIsActive = true;
            return redPencilPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
        else{
            System.out.println("originalPrice cannot be reduced");
            System.out.println("originalPrice: $" + originalPrice);
            return originalPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
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

    public double reduceRedPencilPrice(String reductionPercentage){
        if(promotionIsActive){

        }
        return 0;
    }

    public void increasePriceByAmount(String amount){
        if(promotionIsActive){
            BigDecimal amountToAddToRedPencil = new BigDecimal(amount);
            redPencilPrice = redPencilPrice.add(amountToAddToRedPencil);
            promotionIsActive = false;
        }
    }


}
