import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedPencil {

    private BigDecimal price;

    public RedPencil(String productPrice) {
        this.price = new BigDecimal(productPrice);
    }

    public double getPrice(){
        return price.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
