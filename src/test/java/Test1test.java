import org.junit.Assert;
import org.junit.Test;
import test1.Test1;

public class Test1test {
    @Test
   public void testInput(){
        String input1 = "N300";
        String input2 = "Y10";
        String input3 = "N0.11";
        Assert.assertTrue(Test1.isValidInput(input1));
        Assert.assertFalse(Test1.isValidInput(input2));
        Assert.assertFalse(Test1.isValidInput(input3));
   }
}
