package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
public class UserAbsRepositoryTest {

    private UserRepository userRepository;
    private CommonUserAbs user1;
    @BeforeEach
    public void setUp(){
        this.userRepository = new UserRepositoryImpl();

        user1 = new CommonUserAbs(1,
                Platform.AMAZON_PREMIUM,
                Type_User.COMMON,
                "ale123","Argentina");

        this.userRepository.addUser(user1);
    }

    @Test void repositoryAddUser(){
        UserAbs recuperedUserAbs = this.userRepository.getUser(1);
        assertEquals(user1.getNick(), ((CommonUserAbs) recuperedUserAbs).getNick());
    }

    @Test void repositoryCantAddUser(){
        assertThrows(UserHasBeenAddedException.class, ()-> this.userRepository.addUser(user1));
    }

    @Test void repositoryGetAllUsers(){
        assertEquals(1, userRepository.getUsers().size());
    }

    @Test void repositoryGetUser(){
        assertEquals(user1.getNick(), ((CommonUserAbs) userRepository.getUser(1)).getNick());
    }

}
*/