import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal price;
    private int durationOfPromotion;
    private boolean stablePrice;

    public RedPencil(String originalPrice) {
        this.price = new BigDecimal(originalPrice);
        this.durationOfPromotion = 0;
        this.stablePrice = false;
    }

    public double getPrice(){
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
            stablePrice = true;
            return stablePrice;
        }
        else{
            return false;
        }
    }

    public void priceToReduce(String reducedPrice){

    }

}
