package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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