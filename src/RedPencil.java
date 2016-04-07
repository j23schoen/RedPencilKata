import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal price;
    private int durationOfPromotion;

    public RedPencil(String originalPrice) {
        this.price = new BigDecimal(originalPrice);
        this.durationOfPromotion = 0;
    }

    public double getPrice(){
        System.out.println("price");
        return price.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
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

    public boolean checkFor30StablePrice(){
        if(durationOfPromotion >= 30){
            System.out.println("price stable");
            return true;
        }
        else{
            System.out.println("price not stable");
            return false;
        }
    }

    public double reducePrice(String reductionPercentage){
        BigDecimal percentToReduceBy = new BigDecimal(reductionPercentage);

        if(checkFor30StablePrice()){
            if(percentToReduceBy.doubleValue() >= .05 && percentToReduceBy.doubleValue() <= .30){
                BigDecimal percentageOfPrice = price.multiply(percentToReduceBy);
                price = price.subtract(percentageOfPrice);
            }
            System.out.println("price: $" + price);
            return price.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
        else{
            System.out.println("price cannot be reduced because the previous price hasn't been stable for 30 days");
            System.out.println("price: $" + price);
            return price.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
    }



}
