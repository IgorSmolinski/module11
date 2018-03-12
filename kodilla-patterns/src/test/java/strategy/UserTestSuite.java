package strategy;

import com.igor.patterns.strategy.model.Millenials;
import com.igor.patterns.strategy.model.User;
import com.igor.patterns.strategy.model.YGeneration;
import com.igor.patterns.strategy.model.ZGeneration;
import com.igor.patterns.strategy.services.FacebookPublisher;
import com.igor.patterns.strategy.services.SnapchatPublisher;
import com.igor.patterns.strategy.services.TwitterPublisher;
import org.junit.*;

public class UserTestSuite {

    @BeforeClass
    public static void  before(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Starts tests");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
    }

    @AfterClass
    public static void after(){
        System.out.println("**********************");
        System.out.println("Ending tests");
        System.out.println("**********************");
    }

    @After
    public void afterEvery() {
        System.out.println("--------------------");
    }

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User stefan = new Millenials("Stefan");
        User heniek = new YGeneration("Heniek");
        User alojzy = new ZGeneration("Alojzy");

        //When
        String stefanUse = stefan.sharePost();
        System.out.println("Stefan is using: " + stefanUse);
        String heniekUse = heniek.sharePost();
        System.out.println("Heniek is using: " + heniekUse);
        String alojzyUse = alojzy.sharePost();
        System.out.println("Alojzy is using: " + alojzyUse);

        //Then
        Assert.assertEquals("Facebook", stefanUse);
        Assert.assertEquals("Twitter", alojzyUse);
        Assert.assertEquals("Snapchat", heniekUse);
    }

    @Test
    public void testIndividualShareStrategy(){
        //Given
        User stefan = new Millenials("Stefan");
        User heniek = new YGeneration("Heniek");
        User alojzy = new ZGeneration("Alojzy");

        //When
        String stefanUse = stefan.sharePost();
        System.out.println("Stefan is using: " + stefanUse);
        stefan.setSocialPublisher(new TwitterPublisher());
        stefanUse = stefan.sharePost();
        System.out.println("Stefan is using: " + stefanUse);

        String heniekUse = heniek.sharePost();
        System.out.println("Heniek is using: " + heniekUse);
        heniek.setSocialPublisher(new FacebookPublisher());
        heniekUse = heniek.sharePost();
        System.out.println("Heniek is using: " + heniekUse);

        String alojzyUse = alojzy.sharePost();
        System.out.println("Alojzy is using: " + alojzyUse);
        alojzy.setSocialPublisher(new SnapchatPublisher());
        alojzyUse = alojzy.sharePost();
        System.out.println("Alojzy is using: " + alojzyUse);

        //Then
        Assert.assertEquals("Twitter", stefanUse);
        Assert.assertEquals("Snapchat", alojzyUse);
        Assert.assertEquals("Facebook", heniekUse);
    }
}
