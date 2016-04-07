import org.junit.Assert;
import org.junit.Test;

public class RedPencilTests {

    @Test
    public void priceWillReturnTheRightPriceInput(){
        RedPencil test = new RedPencil("10.50");
        Assert.assertEquals(10.50, test.getOriginalPrice(), 0);
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

    @Test
    public void priceShouldReturnTrueForBeingStable(){
        RedPencil test = new RedPencil("4");
        test.addDaysOfDuration(31);
        Assert.assertEquals(true, test.checkForStability());
    }

    @Test
    public void priceShouldReturnFalseForNotBeingStable(){
        RedPencil test = new RedPencil("4");
        test.addDaysOfDuration(3);
        Assert.assertEquals(false, test.checkForStability());
    }

    @Test
    public void reduce10By7PercentShouldReturn930(){
        RedPencil test = new RedPencil("10");
        test.addDaysOfDuration(31);
        Assert.assertEquals(9.30, test.reduceOriginalPriceByPercentage("0.07"), 0);
        Assert.assertEquals(0, test.getDuration());
    }

    @Test
    public void priceShouldNotBeReducedBecauseNotStable(){
        RedPencil test = new RedPencil("10");
        test.addDaysOfDuration(3);
        Assert.assertEquals(10, test.reduceOriginalPriceByPercentage(".14"), 0);
    }

    @Test
    public void priceShouldNotBeReducedBecauseTooBigOfPercentage(){
        RedPencil test = new RedPencil("10");
        test.addDaysOfDuration(31);
        Assert.assertEquals(10, test.reduceOriginalPriceByPercentage(".37"), 0);
    }

    @Test
    public void priceShouldNotBeReducedBecauseTooSmallOfPercentage(){
        RedPencil test = new RedPencil("10");
        test.addDaysOfDuration(31);
        Assert.assertEquals(10, test.reduceOriginalPriceByPercentage(".03"), 0);
    }

    @Test
    public void reduce10By15AndThenBy10ShouldReturn765(){
        RedPencil test = new RedPencil("10");
        test.addDaysOfDuration(34);
        test.reduceOriginalPriceByPercentage(".15");
        Assert.assertEquals(7.65, test.reduceRedPencilPrice(".10"), 0);
        Assert.assertEquals(7.65, test.reduceRedPencilPrice(".75"), 0);
    }
}
