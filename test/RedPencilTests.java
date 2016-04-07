import org.junit.Assert;
import org.junit.Test;

public class RedPencilTests {

    @Test
    public void priceWillReturnTheRightPriceInput(){
        RedPencil test = new RedPencil("10.50");
        Assert.assertEquals(10.50, test.getPrice(), 0);
    }

    @Test
    public void returnDuration(){
        RedPencil test = new RedPencil("3");
        Assert.assertEquals(0, test.getDuration());
    }

    @Test
    public void durationGreaterThanZeroReturn(){
        RedPencil test = new RedPencil("3");
        test.addDaysOfDuration(17);
        Assert.assertEquals(17, test.getDuration());
    }

}
