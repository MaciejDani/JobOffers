package com.junioroffers.domain.loginandregister;

import java.util.Optional;

public interface LoginRepository {

    public Optional<User> findByUsername(String username);
    public User save(User entity);
}
