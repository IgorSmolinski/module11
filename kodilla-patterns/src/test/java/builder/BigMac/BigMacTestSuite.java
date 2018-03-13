package builder.BigMac;

import com.igor.patterns.builder.bigmac.BigMac;
import org.junit.Assert;
import org.junit.Test;

import static com.igor.patterns.builder.bigmac.BigMac.*;


public class BigMacTestSuite {
    @Test
    public void testBigMacBuilder(){
        //Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .burgers(4)
                .roll(SEZAM)
                .sauce(THOUSAND)
                .ingredient("Tomato")
                .ingredient("Onion")
                .ingredient("Cucumber")
                .ingredient("Bekon")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        boolean itContains = bigmac.getIngredients().contains("Garlic");
        boolean itContains2 = bigmac.getIngredients().contains("Onion");

        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals(false, itContains);
        Assert.assertEquals(true, itContains2);
    }


}
