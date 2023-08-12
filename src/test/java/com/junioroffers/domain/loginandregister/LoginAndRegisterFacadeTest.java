package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class LoginAndRegisterFacadeTest {

    private final LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryLoginRepository());

    @Test
    public void should_throw_exception_when_user_not_found() {
    //given
    String username = "someUser";
    //when
    //then
    assertThrows(UsernameNotFoundException.class, () -> loginAndRegisterFacade.findByUsername(username), "User not found");
    }

    @Test
    public void should_find_user_by_user_name() {
    //given
    RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass123");
    RegistrationResultDto register = loginAndRegisterFacade.register(registerUserDto);
    //when
    UserDto userDto = loginAndRegisterFacade.findByUsername(register.username());
    //then
    assertThat(userDto).isEqualTo(new UserDto(register.id(), "pass123", "username"));

    }

    @Test
    public void should_register_user() {
    //given
    RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass");
    //when
    RegistrationResultDto registeredUser = loginAndRegisterFacade.register(registerUserDto);
    //then
    assertThat(registeredUser.username()).isEqualTo("username");
    assertThat(registeredUser.created()).isTrue();
    }

}