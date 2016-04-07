import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal originalPrice;
    private BigDecimal redPencilPrice;
    private boolean promotionIsActive;
    private double totalPercentageOffOriginal;
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
            updateRedPencilPrice(percentageOfOriginalPrice);
            resetDuration();
            promotionIsActive = true;
            return redPencilPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
        else{
            System.out.println("originalPrice cannot be reduced");
            System.out.println("originalPrice: $" + originalPrice);
            promotionIsActive = false;
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
        BigDecimal percentToReduceBy = new BigDecimal(reductionPercentage);

        if(promotionIsActive && !checkIfPercentOffOriginalIsGreaterThan30()){
            BigDecimal percentageOfRedPencilPrice = redPencilPrice.multiply(percentToReduceBy);
            updateRedPencilWhileInPromotion(percentageOfRedPencilPrice);
            promotionIsActive = true;
            System.out.println(redPencilPrice);
            return redPencilPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
        else{
            System.out.println("redPencil cannot be reduced");
            promotionIsActive = false;
            return redPencilPrice.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
    }

    private void updateRedPencilWhileInPromotion(BigDecimal value){
        redPencilPrice = redPencilPrice.subtract(value);
    }

    public boolean increasePriceByAmount(String amount){
        if(promotionIsActive){
            BigDecimal amountToAddToRedPencil = new BigDecimal(amount);
            redPencilPrice = redPencilPrice.add(amountToAddToRedPencil);
            promotionIsActive = false;
            return false;
        }
        else{
            promotionIsActive = true;
            return true;
        }
    }

    private double findPercentOffFromOriginalPrice(){
        double divisorOfOriginalAndRedPencil;
        divisorOfOriginalAndRedPencil = redPencilPrice.doubleValue()/originalPrice.doubleValue();

        double percentDifference;
        percentDifference = 1 - divisorOfOriginalAndRedPencil;

        totalPercentageOffOriginal += percentDifference;

        System.out.println("total percentage off original: " + totalPercentageOffOriginal);
        return totalPercentageOffOriginal;
    }

    private boolean checkIfPercentOffOriginalIsGreaterThan30(){
        if(findPercentOffFromOriginalPrice() > .30){
            System.out.println("reduction percentage exceeds amount from original price");
            promotionIsActive = false;
            return true;
        }
        else{
            return false;
        }
    }


}
