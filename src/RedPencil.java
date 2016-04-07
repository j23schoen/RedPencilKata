import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal price;
    private int durationOfPromotion;

    public RedPencil(String productPrice) {
        this.price = new BigDecimal(productPrice);
        this.durationOfPromotion = 0;
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


}
