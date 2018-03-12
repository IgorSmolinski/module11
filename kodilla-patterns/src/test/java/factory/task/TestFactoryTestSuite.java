package factory.task;

import com.igor.patterns.factory.task.ShoppingTask;
import com.igor.patterns.factory.task.Task;
import com.igor.patterns.factory.task.TaskFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestFactoryTestSuite {
    @Test
    public void testCreateShopping(){
        //Given
        //When
        Task shoping = new TaskFactory().makeTask("SHOP");
        //Then
        Assert.assertEquals("zakupy", shoping.getTaskName());
    }

    public void testCreateDriving(){
        //Given
        //When
        Task driving= new TaskFactory().makeTask("DRIVE");
        //Then
        Assert.assertEquals("jedziemy", driving.getTaskName());
    }

    public void testCreatePainting(){
        //Given
        //When
        Task painting = new TaskFactory().makeTask("SHOP");

        //Then
        Assert.assertEquals("zakupy", painting.getTaskName());
    }

    @Test
    public void testIsExecuted(){
        //Given
        Task painting = new TaskFactory().makeTask("SHOP");

        //When
        boolean isExecuted = painting.isTaskExecuted();
        System.out.println("Task is executed = " + isExecuted);
        painting.executeTask();
        isExecuted = painting.isTaskExecuted();
        System.out.println("Task is executed = " + isExecuted);

        //Then
        Assert.assertEquals(true, isExecuted);

    }
}
