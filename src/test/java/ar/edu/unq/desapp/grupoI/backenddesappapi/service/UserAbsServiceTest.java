package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

public class UserAbsServiceTest {

    @Mock
    private UserRepository userRepository;

    private List<UserAbs> users;
    private UserService userService;

    @BeforeEach
    public void setUp(){
        users = new ArrayList<UserAbs>();
        MockitoAnnotations.initMocks(this);
        UserAbs jose = new UserAbs(4L,
                "",
                Platform.DISNEY_PLUS.name(),
                Type_User.COMMON.name(),
                "Jose1990",
                "AR",
                null);
        userService = new UserService(userRepository);
        userService.save(jose);
        users.add(jose);
    }

    @Test
    public void getUsersTest(){
        doReturn(users).when(userRepository).findAll();
        Assertions.assertEquals(1, userService.findAll().size());
    }

    @Test
    public void getUserTest(){
        doReturn(users.get(0)).when(userRepository).findBy(4);
        Assertions.assertEquals("Jose1990", ( userService.findBy(4)).getNickname());
    }

    @Test
    public void addUserTest(){
        doReturn(users).when(userRepository).findAll();
        UserAbs alejadro = new UserAbs(1L, "",
                Platform.AMAZON_PREMIUM.name(),
                Type_User.COMMON.name(),
                "ale123","Argentina", null);
        users.add(alejadro);
        userService.save(alejadro);
        Assertions.assertEquals(2, userService.findAll().size());
    }

    @Test
    public void  userNotFoundTest(){
        doThrow( new UserNotFoundException(HttpStatus.BAD_REQUEST)).when(userRepository).findById(567);
        assertThrows(UserNotFoundException.class, ()-> this.userService.findBy(567));
    }
    @Test
    public void  findUserByLocation(){
        doReturn(users.stream()
                      .filter(u -> u.getType_user() == Type_User.COMMON.name() && u.getLocation() == "AR")
                      .collect(Collectors.toList()))
                .when(userRepository).findUserByLocation("AR");
        assertEquals(1, this.userService.findUserByLocation("AR").size());
    }
    @Test
    public void  findUserByPlatform(){
        doReturn(users.stream()
                .filter(u -> u.getPlatform() == Platform.DISNEY_PLUS.name())
                .collect(Collectors.toList()))
                .when(userRepository).findUserByPlatform("DISNEY_PLUS");
        assertEquals(1, this.userService.findUserByPlatform("DISNEY_PLUS").size());
    }
    @Test
    public void  findUserByTypeUser(){
        doReturn(users.stream()
                .filter(u -> u.getType_user() == Type_User.COMMON.name())
                .collect(Collectors.toList()))
                .when(userRepository).findUserByTypeUser("COMMON");
        assertEquals(1, this.userService.findUserByTypeUser("COMMON").size());;
    }
}
