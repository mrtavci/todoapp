import com.hepsiemlak.todoapp.model.UserModel;
import com.hepsiemlak.todoapp.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final Integer RANDOM_NUMBER = new Random().nextInt();

    @Mock
    private UserServiceImpl serviceImp;

    private UserModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new UserModel();
        model.setId(RANDOM_NUMBER);
        model.setName("TestName");
        model.setSurname("Surname");
        model.setMail("Mail");
        model.setTaskList(new ArrayList<>());
    }

    @Test
    public void saveTest() {
        Logger.getAnonymousLogger().info("savedTest");
        serviceImp.save(model);
    }





}
