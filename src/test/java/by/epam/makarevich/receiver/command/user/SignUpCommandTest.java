package by.epam.makarevich.receiver.command.user;

import by.epam.makarevich.command.user.SignUpCommand;
import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.impl.UserReceiverImpl;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.RouterType;
import by.epam.makarevich.util.Router;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SignUpCommandTest {
    @Mock
    private UserReceiverImpl receiver;
    @InjectMocks
    private SignUpCommand signUpCommand;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void execute() throws ReceiverException {
        RequestContent requestContent = new RequestContent();
        Router router = new Router();
        router.setPath(GeneralConstant.CommonPageConstant.AFTER_SIGN_UP_PAGE);
        router.setType(RouterType.REDIRECT);
        Assert.assertEquals(router.getPath(), signUpCommand.execute(requestContent).getPath());
    }
}
