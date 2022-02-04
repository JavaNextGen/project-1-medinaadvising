package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.repositories.UserDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.Role;
import com.revature.models.User;

public class UserServiceTest {

    private static UserService userService;
    private static UserDAO userDAO;

    private User GENERIC_EMPLOYEE_1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        userService = new UserService();
        userDAO = mock(UserDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new User();
    }

    @Test
    public void testGetByUsernamePassesWhenUsernameExists() {
        when(userDAO.getUserByRole(anyString()));

        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), userService.getByUsername(GENERIC_EMPLOYEE_1.getUsername()));

        verify(userDAO).getUserByRole(GENERIC_EMPLOYEE_1.getUsername());
    }
}
