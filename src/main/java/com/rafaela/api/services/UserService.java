package com.rafaela.api.services;

import com.rafaela.api.domain.User;

public interface UserService {
    User findById(Integer id);
}
