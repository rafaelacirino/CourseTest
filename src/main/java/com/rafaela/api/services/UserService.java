package com.rafaela.api.services;

import com.rafaela.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
