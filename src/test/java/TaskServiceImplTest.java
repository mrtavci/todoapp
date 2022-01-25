import com.hepsiemlak.todoapp.model.TaskModel;
import com.hepsiemlak.todoapp.service.impl.TaskServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {
    private static final Integer RANDOM_NUMBER = new Random().nextInt();

    @Mock
    private TaskServiceImpl serviceImp;

    private TaskModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new TaskModel();
        model.setId(RANDOM_NUMBER);
        model.setName("TestName");
        model.setDescription("Test");
        model.setDate(new Date());
    }

    @Test
    public void saveTest() {
        Logger.getAnonymousLogger().info("savedTest");
        serviceImp.save(model);
    }





}
