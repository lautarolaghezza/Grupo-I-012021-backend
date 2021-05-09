package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
/*
public class UserAbsServiceTest {

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp(){
        CommonUserAbs jose = new CommonUserAbs(4,
                Platform.DISNEY_PLUS,
                Type_User.COMMON,
                "Jose1990",
                "Argentina");
    userService = new UserServiceImpl();
    userService.addUser(jose);
    }

    @Test
    public void getUsersTest(){
        Assertions.assertEquals(1, userService.getUsers().size());
    }

    @Test
    public void getUserTest(){
        Assertions.assertEquals("Jose1990", ((CommonUserAbs) userService.getUser(4)).getNick());
    }

    @Test
    public void addUserTest(){
        CommonUserAbs alejadro = new CommonUserAbs(1,
                Platform.AMAZON_PREMIUM,
                Type_User.COMMON,
                "ale123","Argentina");

        userService.addUser(alejadro);
        Assertions.assertEquals("ale123", ((CommonUserAbs) userService.getUser(1)).getNick());
    }

    @Test
    public void  userNotFoundTest(){
        assertThrows(UserNotFoundException.class, ()-> this.userService.getUser(567));
    }
}
*/