package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repository.user.UserRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repository.user.UserRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRepositoryTest {

    private UserRepository userRepository;
    private  CommonUser user1;
    @BeforeEach
    public void setUp(){
        this.userRepository = new UserRepositoryImpl();

        user1 = new CommonUser(1,
                Platform.AMAZON_PREMIUM,
                Type_User.COMMON,
                "ale123","Argentina");

        this.userRepository.addUser(user1);
    }

    @Test void repositoryAddUser(){
        User recuperedUser = this.userRepository.getUser(1);
        assertEquals(user1.getNick(), ((CommonUser) recuperedUser).getNick());
    }

    @Test void repositoryCantAddUser(){
        assertThrows(UserHasBeenAddedException.class, ()-> this.userRepository.addUser(user1));
    }

    @Test void repositoryGetAllUsers(){
        assertEquals(1, userRepository.getUsers().size());
    }

    @Test void repositoryGetUser(){
        assertEquals(user1.getNick(), ((CommonUser) userRepository.getUser(1)).getNick());
    }

}