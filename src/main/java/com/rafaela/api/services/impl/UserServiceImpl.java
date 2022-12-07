package com.rafaela.api.services.impl;

import com.rafaela.api.domain.User;
import com.rafaela.api.domain.dto.UserDTO;
import com.rafaela.api.repositories.UserRepository;
import com.rafaela.api.services.UserService;
import com.rafaela.api.services.exceptions.DataIntegratyViolationException;
import com.rafaela.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema");
        }
    }
}
