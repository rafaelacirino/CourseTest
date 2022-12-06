package com.rafaela.api.services;

import com.rafaela.api.domain.User;
import com.rafaela.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
}
